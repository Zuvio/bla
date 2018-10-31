"# todofixed" 

application.properties had to suffix ?serverTimezone=UTC behind the spring.datasource.url=jdbc:mysql://localhost/todo?serverTimezone=UTC
in order to fix the timezone problem

todo is oude situatie met teveel configuratie dus daarom niet zelf gebouwd

Package 'Model' = 1e pijler
Package 'controller' = 2e pijler
Package 'service' = 3e pijler

@Controller //vertegenwoordigt servlet functionaliteit dus middelste pijler van de 3
@ResponseBody //geeft aan: niet moeilijk doen met zoeken naar jsp, maar gewoon de return waarde teruggeven
@GetMapping("/hallo") //geeft de url aan war die naar zoekt, direct achter localhost
model heeft de data / controller heeft de functies
los van alles is de application, daar kom je nooit aan is puur voor de main().

                    model
blokjes zijn: web controller services
                     app
                    config

0) web heeft de jsp, deze worden vervangen door rest api is de nieuwe situatie
standaard formulier jsp form en list. druk op knop = ga naar create en save() want action="create" -> in controller "/create".
0) model heeft de waarden (id + task). Heeft getters/setters en altijd een een public default constructor. Genereert SQL
service maakt sql van de model gegevens via CRUDrepository (= 1 zinnetje) op basis van methodes wordt sql gemaakt
    - findall() = select * from
    - delete() = deleter from where etc.
    - save() = create + update
0) controller ontvangt request en delegeert aan de services obv de gekozen functie()

bij RequestMaping zeg je dat hij de waarde uit het http bericht (task) moet proberen te mappen op iets uit de Todo klasse.
Variabele zoeken. Vind hij niets? doet hij niets. Spring maakt de instantie aan dus onderwater ergens new Todo()
new Todo() maak je niet zelf aan tenzij je weet wat jed oet.
Services specificeert de Todo klasse, dus hij verwacht met Todo instanties te maken te hebben
de return van create is ook gelijk een niewie sql select * om de lijst op scherm te tonen

Bij nieuwe functionaliteit: wat wil je doen en waar zou je wat aan moeten passen? Nieuwe veldje erbij, wat moet je allemaal doen?
	- iets met het formulier? iets met de model (variabele/getset/constructor)? iets met de list? loopje?
Voeg een extra veld toe met assignee ofdescription
Voeg een knop toe die de hele database dropped

Model model is dingen naarde jsp door moeten sturen. Is met json niet meer nodig. dus findAll(Model model) --> findAll2()

@ResponseBody : hiermee vertel je dat hij niet meer naar een jsp moet gaan