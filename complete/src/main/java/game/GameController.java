package game;

import model.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    Game game;

    public GameController() {
        game = new Game();

    }

    @GetMapping("/gissa")
    public String gissa(@RequestParam(name = "ledtrad", required = false, defaultValue = "") String ledtrad, Model model) {
        System.out.printf("-%s-\n", ledtrad);
        if (ledtrad.equals("")) {
            game.resetGame();
            game.setGissning((game.getMinsta() + game.getMesta()) / 2);
            System.out.printf("startar om, %d, %d, %d, \n", game.getMinsta(), game.getMesta(), game.getGissning());

        }
        if (ledtrad.equals("högre")) {

            game.incGissningar();
            game.setMinsta(game.getGissning());

            game.setGissning((game.getMinsta() + game.getMesta()) / 2);
            System.out.printf("gissade högre, %d, %d, %d, \n", game.getMinsta(), game.getMesta(), game.getGissning());

        }
        if (ledtrad.equals("lägre")) {

            game.incGissningar();
            game.setMesta(game.getGissning());


            game.setGissning((game.getMinsta() + game.getMesta()) / 2);
            System.out.printf("gissade lägre, %d, %d, %d, \n", game.getMinsta(), game.getMesta(), game.getGissning());

        }

        model.addAttribute("gissning", game.getGissning());
        return "gissa";
    }

    @GetMapping("/vann")
    public String vann(@RequestParam(name = "gissningar", required = false, defaultValue = " inget ") String name, Model model) {
        if (game.getGissningar() < game.getHighScore()) game.setHighScore(game.getGissningar());

        model.addAttribute("gissningar", game.getGissningar());
        model.addAttribute("highscore", game.getHighScore());

        return "vann";
    }

    @GetMapping("/reset")
    public String reset( @RequestParam(name = "gissningar", required = false, defaultValue = " inget ") String name,  Model model) {
        game.setHighScore(9999);

        model.addAttribute("highscore", game.getHighScore());

        return "reset";
    }
 
}
