package com.hoangdev.Classroom.service.news;

import com.hoangdev.Classroom.models.News;
import com.hoangdev.Classroom.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<News> getNewsById(Long id) {
        return null;
    }

    @Override
    public void addNews(News news) {

    }

    @Override
    public News getNewsByNewsId(Long id) {
        return null;
    }

    @Override
    public List<News> getByClassId(Long id) {
        return null;
    }

    @Override
    public Page<News> findPaginated(Long classroomId, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum-1, pageSize);

        return newsRepository.findByClassroomIdPagination(classroomId, pageable);
    }

    @Override
    public void deleteNews(News news) {

    }
}
