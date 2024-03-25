package com.hoangdev.Classroom.service.news;

import com.hoangdev.Classroom.models.News;
import com.hoangdev.Classroom.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {

    void save(News news);
    List<News> getAllNews();
    List<News> getNewsByClassId(int classId);
    List<News> getNewsById(Long id);
    void addNews(News news);
    News getNewsByNewsId(Long id);
    List<News> getByClassId(Long id);
    Page<News> findPaginated(Long classroomId, int pageNum, int pageSize);
    void deleteNews(News news);

}
