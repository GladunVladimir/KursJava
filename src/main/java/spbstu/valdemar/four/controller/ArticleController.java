package spbstu.valdemar.four.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spbstu.valdemar.four.domain.Article;
import spbstu.valdemar.four.repository.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/article")
public class ArticleController {
  private final ArticleRepository articleRepository;

  @GetMapping
  @PreAuthorize("isAuthenticated()")
  public List<Article> getAll() {
    return StreamSupport
        .stream(articleRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Article getOne(@PathVariable("id") Article article) {
    return article;
  }

  @PostMapping
  @PreAuthorize("isAuthenticated()")
  public Article saveOne(@RequestBody Article article) {
    return articleRepository.save(article);
  }

  @PutMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public Article updateOne(@PathVariable("id") Article articleFromDb, @RequestBody Article updatedArticle) {
    BeanUtils.copyProperties(updatedArticle, articleFromDb, "id");

    return articleRepository.save(articleFromDb);
  }

  @DeleteMapping("{id}")
  @PreAuthorize("isAuthenticated()")
  public void deleteOne(@PathVariable("id") Article article) {
    articleRepository.delete(article);
  }
}
