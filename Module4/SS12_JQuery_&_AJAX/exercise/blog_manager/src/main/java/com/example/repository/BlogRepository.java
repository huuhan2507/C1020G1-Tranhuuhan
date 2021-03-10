package com.example.repository;

import com.example.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAll();

    Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable);


    Page<Blog> findBlogByNameContains(String search, Pageable pageable);

   Page<Blog> findBlogByOrderByDateAsc(Pageable pageable);

}
