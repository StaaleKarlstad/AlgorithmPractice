# Kjøretid! *tut tut*

Beskriver forholdet mellom tiden det tar for koden å kjøre og inputen den får inn.
Vi vil vite hvordan kjøretiden vokser ved forskjellig størrelse på input

Andre faktorer: Hvor rask er PCen? Hvor mange andre programmer kjører samtidig? Hvilket programmeringsspråk brukes?

## ArrayList

    - get()
        - O(1)
    
    - set()
        - O(1)
    
    - add(element):      
        - O(1) hvis elementet legges til sist i listen
        - O(n) hvis arrayet er fullt. Elementene må da kopieres over til en ny, større liste
    
    - add(index, element)
        - O(n) fordi alle elementer som kommer etter det nye elementet må reindexeres
        - O(1) hvis elementet legges til sist i listen
    
    - remove()  
        - O(1) hvis det siste elementet fjernes, ellers O(n)
      
    - contains()
        - O(n) da metoden potensielt må iterere alle elementer i listen
    - clear()
        - O(n) da metoden må slette alle elementer én etter én

## LinkedList

En linked list i Java er en serie med individuelle noder der hver node kjenner til verdien den holder på, samt hvilken node som kommer før- og etter den i listen.
Ulikt en ArrayList, hvor datastrukturen holder rede på sine elementer ved å tildele dem en index, vet en Javas Linked List bare hvilken node som er først og hvilken node som er sist i listen.
All iterering gjennom listen må derfor skje med en av disse nodene som utgangspunkt

Dette sørger for at metodenes kjøretid ofte avhenger av om elementet er plassert først, sist, eller alle andre steder i listen. Listens enkle tilgang til de to førstnevnte gjør at operasjoner som involverer disse gjerne har kjøretid O(1).
Hvis vi derimot vil interagere med et element midt i listen må vi belage oss på O(n) kjøretid, da vi potensielt må iterere n elementer.

I andre implementasjoner (ikke Java) kan det også være vanlig for en Linked List å bare kjenne til det første elementet og også at noder bare kjenner til noden som kommer etter dem i rekken.

    - get() 
        - O(n) hvis elementet ikke er først eller sist.
        - O(1) hvis elementet er først eller sist  
    
    - set()
        - O(n) hvis elementet ikke er først eller sist.
        - O(1) hvis elementet er først eller sist 
    
    - add(element):      
        - O(1). Elementet legges til sist i listen
    
    - add(index, element)
        - O(n) fordi elementene i en LinkedList ikke har en index. 
        - Her må en for-løkke iterere seg frem til riktig element (n=index antall iterasjoner).  
            
    - remove()  
        - O(n) hvis elementet ikke er først eller sist.
        - O(1) hvis elementet er først eller sist 
        
      
    - contains()
        - O(n) da metoden potensielt må iterere alle elementer i listen
    - clear()
        - O(n) da metoden må slette alle elementer én etter én

## Stack

LIFO - Last In First Out.

Stacken bryr seg om rekkefølgen elementene ble lagt til i og fungerer likt som en ekte stabel. Det øverste elementet i stabelen (skjorte, pannekake, bowlingball(vågalt!)) er det eneste elementet vi kan hente ut. Skal vi legge til et element, må dette dette plasseres først/på toppen av stabelen.

Kan implementeres med Array eller LinkedList som underliggende struktur.
Stacken gir oss nyttige restriksjoner for hvordan vi kan interagere med den underliggende datastrukturen. Av og til trenger vi ikke alle mulighetene tilbudt oss av f.eks en ArrayList. Koden kan bli både sikrere og tydeligere av pålagte begrensinger.  

    - push() O(1)
      - Kan være O(n) hvis stacken er implementert ved bruk av array.
      - Hvis arrayet er fullt må elementene kopieres over til en ny, større liste  
    
    - pop() O(1)
    - peek() O(1)
    - search()

## PriorityQueue/Heap

Implementert som en heap i Java.
Kan ta en comparator som argument, slik at heapen kan struktureres etter brukerens ønskede egenskaper.

I likhet med stack kan vi også her bare hente ut det første/øverste elementet. Men i motsetning til stacken hvor det alltid er det siste tillagte elementet som kan hentes ut, bryr heapen seg om en prioritert, målbar egenskap ved elementene og ordner rekkefølgen deretter.

En heap er et balansert binært tre. Operasjoner som henter ut/setter inn elementer i heapen trigger omstrukturering av treet (forelder-noder og barnenoder bytter plass) og har derfor log(n) kjøretid

    - Offer()/add()        
        - O(log(n))
    
    - Poll()
        - O(log(n))
    
    - Remove(Element)
        - O(n)
        - Når remove() mottar elementet du ønsker å fjerne, må den potensielt iterere hele køen - for å finne det.

    - Contains(Element)
        - O(n)

    - Peek()
        - 0(1)

## HashMap

Rask og effektiv datastruktur brukt for å lagre nøkkel-verdi-par.
Nøklene brukes til insert-, delete- og loopup-operasjoner og verdiene assosiert med dem kan være stort sett hva du ønsker, men datatypene må være konsistent.
F.eks: ```HashMap<Integer, Boolean>``` sier at alle nøkler vi legger til i HashMapet må være av typen ```Integer``` og alle verdier assosiert med dem må være ```Boolean```.

Hver nøkkel er unik og rekkefølgen er tilfedlig. Det er derfor ikke sikkert at nøklene vil stå i samme orden som de ble lagt til i.  

    - get() 
        - O(1) (Worst case N(logn))
    - put() 
        - O(1)
    - remove() 
        - O(1)
