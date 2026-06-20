package edu.unicen.tallerjava.todo.users;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unicen.tallerjava.todo.log.LogService;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private
    LogService logSvc;

    public static final User DEFAULT_USER = new User("Admin", 0);

    @Autowired
    private
    CurrentUserService currentSvc;

    @Autowired
    private
    UserRepository repo;

    @PostConstruct
    public void setup() {
        repo.save(DEFAULT_USER);
    }

    public List<User> getUsers() {
        ArrayList<User> result = new ArrayList<>();
        for (User user : repo.findAll()) {
            result.add(user);
        }
        result.sort(Comparator.comparing(User::getName));
        return result;
    }

    public User addUser(User user) {
        if(user == null){
            throw new IllegalArgumentException();
        }
        logSvc.addLog("Se agregó el usuario " + user.getName(), user);
        return this.repo.save(user);
    }

    public void clearUsers() {
        logSvc.clear();
        this.repo.deleteAll();
    }

    /**
     * Logea y crea un nuevo usuario con un nombre dado.
     * Busca el id máximo actual en la base y le suma 1 para asignar dicho ID al nuevo usuario.
     * Además, utiliza dicho usuario como usuario actual de la sesión.
     *
     * @param name El nombre del usuario.
     * @return un nuevo User
     */
    public User login(String name) {
        User last = repo.findFirstByOrderByIdDesc().orElse(null);
        int lastId = last == null ? 0 : last.getId();
        lastId++;
        User user = new User(name, lastId);
        currentSvc.setCurrent(user);
        return addUser(user);
    }

    public void setLogSvc(LogService logSvc) {
        this.logSvc = logSvc;
    }
}
