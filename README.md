### Créer une seule route à l'aide d'un contrôleur :

-   Crée un projet Spring, et transforme l'application en contrôleur.
-   Crée une route  `/doctor/<numéro de l'incarnation>`.
-   Pour les numéros de 9 à 13 compris, renvoie les informations sur l'incarnation du Docteur correspondante (voir  [ici](https://en.wikipedia.org/wiki/The_Doctor_%28Doctor_Who%29#Actors)  pour les récupérer). Les informations sont renvoyées au format JSON, et incluent le numéro et le nom sous la forme  `{"number": 13,  "name":  "Jodie Whittaker"}`.
-   Si un paramètre  `details`  est présent dans la requête et vaut  `true`, ajoute dans le JSON retourné le nombre d'épisodes et l'âge de l'incarnation à ses débuts. Par exemple pour le numéro 1 :  `{"number": 1,  "name":  "William Hartnell",  "numberOfEpisodes": 134,  "ageAtStart": 55}`.
-   Pour les autres numéros valides -- de 1 à 8 -- renvoie un statut 303.
-   Si le numéro n'est pas valide, renvoie un statut 404 avec comme information une chaîne de caractères contenant  `"Impossible de récupérer l'incarnation <numéro de l'incarnation>"`.
-   Pousse le contenu de ton projet dans un dépôt GitHub et poste le lien de ton dépôt en guise de solution.

> Attention: le paramètre  `details`  doit être optionnel !

#### Critères de validation

-   Le contrôleur contient 1 seule route  `/doctor/<numéro de l'incarnation>`.
-   La route renvoie un JSON pour les 5 dernières incarnations, un statut 303 pour les plus anciennes, sinon elle renvoie un statut 404 avec un message adapté.
-   Le paramètre  `details`  permet d'obtenir un JSON avec plus de détails.