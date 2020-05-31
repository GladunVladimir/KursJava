package spbstu.valdemar.four.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ForwardController {
  @GetMapping("/**/{path:[^\\.]*}")
  public String redirect() {
    return "forward:/";
  }
}
