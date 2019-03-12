import org.springframework.expression.spel.ast.Operator;
import ru.inovus.carnumbergenerator.repository.RandomCarNumberRepository;
import ru.inovus.carnumbergenerator.service.CarNumberService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        RandomCarNumberRepository randomCarNumberRepository = new RandomCarNumberRepository();
//        CarNumberService carNumberService = new CarNumberService(randomCarNumberRepository);
//        System.out.println(carNumberService.nextNumber());
//
//        System.out.println(carNumberService.randomNumber());
//        for (int i = 0; i < 1000000; i++) {
//            carNumberService.randomNumber();
//        }
//
//        System.out.println(randomCarNumberRepository.size());

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Operator\\Documents\\text.txt"));
        String firstString = bufferedReader.readLine();
        System.out.println(firstString);

    }
}
