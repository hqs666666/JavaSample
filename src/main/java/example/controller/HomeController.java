package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/home")
public class HomeController {
    public void arrayListTest(){
        int[] demo = new int[]{1,5,9,4,88};
        IntStream stream = Arrays.stream(demo);
        int min = stream.min().getAsInt();
        int sum = stream.sum();
        int[] demo1 = stream.filter(x -> x > 2).toArray();
        int[] demo2 = stream.limit(3).toArray();
        int[] demo3 = stream.map(x -> x * 2).toArray();
    }
}
