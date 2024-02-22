package com.freelancing.webapplication.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.freelancing.webapplication.payloads.ApiResponse;
import com.freelancing.webapplication.payloads.CommentDto;
import com.freelancing.webapplication.services.CommentService;

@RestController
	@RequestMapping("freelancing/api/comment")
	public class CommentController {

		@Autowired
		private CommentService commentService;

		@PostMapping("/createComment/{postId}/{portfolioId}")
		public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDTO, @PathVariable Integer postId) {

			CommentDto addedComment = this.commentService.createComment(commentDTO, postId);
			return new ResponseEntity<CommentDto>(addedComment, HttpStatus.OK);
		}

		@DeleteMapping("/deleteComment/{commentId}")
		public ResponseEntity<ApiResponse> deleteCommentById(@PathVariable Integer commentId) {
			this.commentService.deleteComment(commentId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Comment is deleted Successfully", true), HttpStatus.OK);
		}

  @GetMapping("/getAllbyPortFolio/{portfolioId}")
	public ResponseEntity<List<CommentDto>> getAllCommentByPortfolio(@PathVariable Integer portfolioId) {
		List<CommentDto> allPost = this.commentService.getAllCommentByPortFolio(portfolioId);
		return new ResponseEntity<List<CommentDto>>(allPost, HttpStatus.OK);
	}

	  @GetMapping("/getAllbyPost/{postId}")
	public ResponseEntity<List<CommentDto>> getAllCommentByPost(@PathVariable Integer postId) {
		List<CommentDto> allPost = this.commentService.getAllCommentByPost(postId);
		return new ResponseEntity<List<CommentDto>>(allPost, HttpStatus.OK);
	}

	}



