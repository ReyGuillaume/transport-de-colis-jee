# Projet JEE - Transport de colis

* Evan Meziere
* Guillaume Rey

## Choix d'implémentation

Pour notre classe `Colis` nous avons utilisé la lib `lombok` pour générer automatiquement nos getters et nos setters.

Dans la classe OperationBean de notre ejb, nous avons créé les 3 méthodes dont nous allons avoir besoin dans nos servlets : `enregistrerColis`, `getColis` et `updatePosition`.

Pour les 3 urls ci-dessous, nous avons décidé de mettre un `doGet` dans chaque servlet pour servir les pages web ainsi qu'un `doPost` dès que la page contient un formulaire.
Ainsi, on peut traîter la soumission du formulaire dans la même servlet.

## Utilisation

Se rendre sur `http://localhost:8080/colis-web/enregistrerColis` pour enregistrer un colis.
Se rendre sur `http://localhost:8080/colis-web/progressionColis/{projectId}` pour mettre à jour la progression du colis.
Se rendre sur `http://localhost:8080/colis-web/suivreColis/{projectId}` pour suivre un colis et visualiser ses informations.
