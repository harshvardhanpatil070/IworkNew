package com.freelancing.webapplication.services;

import java.util.List;

import com.freelancing.webapplication.modal.UserModel;
import com.freelancing.webapplication.payloads.PostDto;
import com.freelancing.webapplication.payloads.PostResponse;

public interface PostService {

    PostDto createPost(PostDto postDTO, Integer userId, Integer categoryId);

    void deletePost(Integer postId);

    PostDto getPostById(Integer id);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

    List<PostDto> getAllPostByUser(Integer postId);

    List<PostDto> getAllPostByCategory(Integer CategoryId);

    List<PostDto> searchPost(String keyword);

    PostDto updatePost(PostDto postDTO, Integer postId);

    UserModel getUserByPostId(Integer id);

}