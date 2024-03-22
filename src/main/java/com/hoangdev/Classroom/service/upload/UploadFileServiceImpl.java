package com.hoangdev.Classroom.service.upload;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.auth.oauth2.GoogleCredentials;
import com.hoangdev.Classroom.models.Res;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

@Service
public class UploadFileServiceImpl {
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String SERVICE_ACCOUNT_KEY_PATH = getPathToGoogleCredentials();

    private static String getPathToGoogleCredentials() {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDirectory, "cred.json");
        return filePath.toString();
    }

    public Res uploadFileToDrive(File file) {
        Res res = new Res();
        try {
            String folderId = "1zzNkIS5K8nsqzhrpHnGf9KlUTWJtCWQM";
            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(file.getName());
            fileMetaData.setParents(Collections.singletonList(folderId));

            // Xác định kiểu MIME của file dựa trên phần mở rộng của tên file
            String mimeType = getMimeType(file.getName());
            FileContent mediaContent = new FileContent(mimeType, file);

            com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetaData, mediaContent)
                    .setFields("id").execute();
            String fileUrl = "https://drive.google.com/uc?export=view&id=" + uploadedFile.getId();
            System.out.println("File URL: " + fileUrl);
            file.delete();
            res.setStatus(200);
            res.setUrl(fileUrl);
            res.setMessage("Upload file success");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            res.setStatus(500);
            res.setMessage(ex.getMessage());
        }
        return res;
    }

    private String getMimeType(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        switch (extension.toLowerCase()) {
            case "jpg":
            case "jpeg":
            case "png":
                return "image/jpeg";
            case "doc":
            case "docx":
                return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
            case "xls":
            case "xlsx":
                return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            case "java":
                return "text/x-java-source";
            case "zip":
                return "application/zip";
            case "cs":
                return "text/x-csharp";
            default:
                return "application/octet-stream";
        }
    }

    private Drive createDriveService() throws Exception {
        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACCOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));
        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential).build();
    }
}
