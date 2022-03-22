# MoonProject

Moon Project for OCP Training

### Beschrijving

De VN wil dat de maan wordt verdeeld onder de verschillende bondgenoten. Hiervoor is een nieuwe organisatie, de
Verenigde Ruimte Naties, opgericht met als leden de bondgenoten van de VN. Alle inwoners van de deelnemende landen
krijgen een stukje maan, een zogenaamd maanperceel. Elk perceel valt onder één kadastraal land en is van een bepaald
type. De verschillende typen zijn: woonperceel, mijnbouwperceel, waterwinperceel, landbouwperceel of lanceerbasis. Elk
perceel type heeft zo z’n eigen kenmerken, maar ook een aantal overeenkomende kenmerken zoals oppervlakte, begrenzing
etc. De Verenigde Ruimte Naties kunnen beperkingen opleggen op maanpercelen. Een eigenaar kan zijn perceel verkopen aan
iemand anders, mits er geen beperking op ligt. Bij verkoop moet vastgelegd worden op welke datum het eigendomsrecht
overgaat naar een ander persoon. Verkoop/aankoop wordt vastgelegd in een transactie.
---

#### **Opdracht 1**

De maan bestaat uit kadastraal land en moet worden onderverdeeld in verschillende maanpercelen. Deze maanpercelen hebben
een eigenaar. Ook kunnen ze van eigenaar wisselen door transacties (aankoop/verkoop).

Er zijn verschillende types maanpercelen: woonperceel, mijnbouwperceel, waterwinning perceel, landbouwperceel en
lanceerbasisperceel. Sommige type percelen mogen niet verkocht worden.

Alle percelen hebben de volgende eigenschappen: id, locatie, grootte, grens (
Polygoon, een verzamelingen van coördinaten waarbij de eerste en laatste coördinaat hetzelfde zijn waardoor je een
gesloten polygoon hebt).

De specifieke perceeltypes hebben ieder weer hun eigen eigenschappen:

* Woonperceel – hoeveel mensen er kunnen wonen
* Mijnbouwperceel – type delfstof en wat is de opbrengst per jaar in kilo’s
* Waterwinning – hoeveel kubieke meter per jaar
* Landbouwperceel – type gewas en opbrengst
* Lanceerbasis – maximale raketgrootte die kan landen en opstijgen De types gewas en delfstof zijn een vaste lijst.

Dit zijn de mogelijke gewassen in een circulaire kas:
Tomaat, Komkommer, Radijs Sla, Paprika

Dit zijn de mogelijke delfstoffen:
helium-3 iridium regoliet goud palladium platina

De opdracht voor dag 1: maak het UML diagram en codeer dit.

---

#### **Opdracht 2**

De Verenigde Ruimte Naties willen voor hun administratie een aantal zaken op kunnen opvragen:
Maanadministratie met lijst percelen

Maak lambda expressions om de volgende gegevens te verkrijgen:

* Percelen die vaker dan gemiddeld zijn verkocht
* Percelen die veel vaker dan gemiddeld zijn verkocht
* Percelen die minder dan gemiddeld zijn verkocht
* Percelen die veel minder gemiddeld zijn verkocht
* Percelen die meer/minder delfstoffen/gewassen opleveren dan gemiddeld

Ook moet er:

* een methode zijn om het aantal verkochte maanpercelen te berekenen per periode uit te rekenen.
* Een methode om het aantal delfstof percelen en het aantal gewas percelen te berekenen.
* De gemiddelde opbrengst van een perceel per gewas en per delfstof moet berekend kunnen worden.
* Het aantal inwoners ouder dan 30 jaar per woonperceel moet opgevraagd worden.

Dit alles moet periodiek gerapporteerd worden. Deze periode moet flexibel zijn. Om te laten zien dat het werkt graag de
rapportage uitdraaien per maand (mag console applicatie zijn met output van de rapoortage in het console).

---

#### **Deel 3**

De VN wil de administratie van delfstoffen verder uitwerken.

* De enum delfstof wordt vervangen door een immutable object. Dit Object bevat gegevens over bijv. elementnaam,
  elementnummer, stofdichtheid, radioactief. Voor het maken van deze objecten hebben we een klasse DelfstofBuilder
  nodig.
* Maanadministratie moet singleton worden.
* Verder, voor zover dit nog niet is toegepast op het model dient encapsulation te worden toegepast.

---

#### **Deel 4**

Om mensen en waren van de ene plek naar de andere te kunnen vervoeren zijn er op de maan een aantal vervoersbedrijven.

Deze vervoersbedrijven maken gebruik van verschillende vervoersmiddelen, zoals een _**raket**_ of een **_monorail_**. De
vervoersbedrijven hebben voor het verplaatsen van passagier een set van beschikbare zitplaatsen

* per trein,
* per vertrektijd,
* per station. Een passagier kan een plek reserveren, deze plek is dan niet meer beschikbaar. De passagier kan een
  specifieke plek reserveren.

Voor het verplaatsen van vracht worden vrachtlijsten bijgehouden dit zijn queues. Op de vrachtlijsten staan vrachten (
vrachtklasse, met gewicht, inhoud, bederfelijk J/N)
Voor de velden inhoud en gewicht zou gewerkt kunnen worden met een mengsel van long, Long, int en Integer. Met
autoboxing zou de compiler dan zelf moeten bepalen welke methode gebruikt wordt of welke Wrapperclass/primitive er
gebruikt wordt.

Er zijn kratten aanwezig voor bepaald type (delf)stoffen. Er kunnen verschillende types kratten gedefinieerd worden,
verschillende groottes of voor verschillende soorten stoffen: vloeibaar, gas, vast.

De vrachtlijst kan verschillende soorten kratten bevatten.

Er zijn kratten en er zijn passagiers, ze nemen allebei een bepaalde ruimte in. Per rit (van A naar B) wordt gekeken hoe
de vracht en de passagiers zo optimaal mogelijk vervoerd kunnen worden. Zo moet er rekening gehouden worden met wat er
het eerst of het laatst in- of uitgepakt moet worden, denk bijvoorbeeld aan bederfelijk waar. Bij de sortering komen dan
deze kratten bovenaan de lijst.

De beschikbare ruimte moet zo veel mogelijk worden gevuld. Je zou bijvoorbeeld een monorail kunnen hebben waarin tien
kratten passen. Iedereen die iets vervoerd wil hebben zet het in de queue. Als de queue vol is kan de monorail
vertrekken. Je kunt er dan voor kiezen om kratten met bederfelijke waar voorrang te geven in de queue.

De verschillende typen kratten moeten onderling vergeleken kunnen worden en gesorteerd kunnen worden op bepaalde
eigenschappen.

---
