## Mihaela-Diana Pascariu
# Fii Lab 9
* Compulsory : 
    * Am implmentat toate cerintele. Am avut probleme la conectarea bazei de date la consola din persistence, deoarece nu reuseam sa setez proprietatea de serverTimeZone in persistence.xml.
    * Din acest motiv, am folosit o baza de date hostata de altcineva.
    * Am folosit NamedQuery pentru findByName si findByArtist.
* Optional :
    * Am adaugat in baza mea de date tabelele Chart si Chart Position.
    * In folderul entity am adaugat si cele doua clase corespunzatoare tabelelor din baza de date.
    * Am implementat interfata AbstractRepository.
    * In cadrul acesteia, am creat metodele de create, get, save si delete.
    * Am creat doua clase DAO pentru a exemplifica interfata AbstractRepository.
    * Aceste doua clase au fost folosite pentru implementarea partii de JDBC.
    * Am creat un fisier in folderul "app", numit "initializationFile.txt".
    * In acest fisier, am scris, pe linii, fie "JPA", fie "JDBC", care vor dicta ce se va folosi in Main. 