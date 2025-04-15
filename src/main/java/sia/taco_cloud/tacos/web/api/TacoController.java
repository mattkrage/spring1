package sia.taco_cloud.tacos.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.taco_cloud.tacos.Taco;
import sia.taco_cloud.tacos.data.TacoRepository;
import sia.taco_cloud.tacos.messaging.TacoMessagingService;

import java.util.Optional;


@RestController
@RequestMapping(path="/api/tacos",
        produces="application/json")
@CrossOrigin(origins="*")
public class TacoController {

    private TacoRepository tacoRepo;
    private TacoMessagingService messageService;

    public TacoController(TacoRepository tacoRepo, TacoMessagingService messageService) {
        this.tacoRepo = tacoRepo;
        this.messageService = messageService;
    }

    @GetMapping(params="recent")
    public Iterable<Taco> recentTacos() {

        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);

        if (optTaco.isPresent()) {
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        messageService.sendTaco(taco);
        return tacoRepo.save(taco);
    }


}
