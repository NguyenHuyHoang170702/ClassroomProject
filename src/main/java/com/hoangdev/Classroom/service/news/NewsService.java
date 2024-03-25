package com.hoangdev.Classroom.service.news;

import com.hoangdev.Classroom.models.News;
import com.hoangdev.Classroom.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface NewsService {

    void save(News news);
    List<News> getAllNews();
    List<News> getNewsByClassId(int classId);


}
