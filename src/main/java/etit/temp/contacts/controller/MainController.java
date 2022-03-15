package etit.temp.contacts.controller;

import etit.temp.contacts.dal.DataService;
import etit.temp.contacts.models.ContactModel;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  private final static Map<String, String> paths = Map.of("home", "/",
                                                          "index", "/home",
                                                          "add new", "/add",
                                                          "contacts", "/contacts");

  private final DataService dataService;

  @GetMapping("/contacts")
  public ModelAndView getContacts() {

    var mav = getMavWithPaths("contacts");

    mav.addObject("title", "Contacts");
    mav.addObject("models", dataService.getContacts());

    return mav;
  }

  @Autowired
  public MainController(DataService dataService) {

    this.dataService = dataService;
  }

  @GetMapping("/")
  public ModelAndView landing() {

    return getMavWithPaths("landing");
  }

  private ModelAndView getMavWithPaths(String pageName) {

    var mav = new ModelAndView(pageName);
    mav.addObject("paths", paths);
    return mav;
  }

  @GetMapping("/home")
  public ModelAndView index() {

    return getMavWithPaths("index");
  }

  @RequestMapping("/add")
  public ModelAndView addNewContact() {

    var mav = getMavWithPaths("addContact");
    mav.addObject("contact", new ContactModel());
    return mav;
  }

  @PostMapping("/contacts/add")
  public ModelAndView addNew(@ModelAttribute ContactModel contact) {

    var mav = getMavWithPaths("addContact");
    //modelAndView.setViewName("addContact");
    mav.addObject("title", "add new Contact");
    mav.addObject("contact", new ContactModel());

    dataService.write(contact);
    return addNewContact();
  }


  @RequestMapping(value = "/contacts/details/{index}", method = RequestMethod.GET)
  public ModelAndView details(@PathVariable("index") int index) {

    var mav = getMavWithPaths("details");

    var models = dataService.getContacts();

    mav.setViewName("details");
    mav.addObject("model", models.get(index));
    mav.addObject("title", "title");

    return mav;
  }

}
