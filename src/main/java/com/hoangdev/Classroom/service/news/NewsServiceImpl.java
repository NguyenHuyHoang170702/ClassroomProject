package com.hoangdev.Classroom.service.news;

import com.hoangdev.Classroom.models.News;
import com.hoangdev.Classroom.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> getNewsByClassId(int classId) {
        return newsRepository.findNewsByClassroomId(classId);
    }
}
