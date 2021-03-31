#language: fr
@regression
Fonctionnalité: Créer, Modifier, Supprimer un Catalogue
  En tant qu'utilisateur
  Je souhaite créer, modifier, supprimer, reouvrir et lister les catalogues de besoins

  Contexte:
    Etant donné que je suis connecté
    Quand dans le menu, je clique sur le lien Catalogue
    Alors la liste des catalogues de besoin s'affiche

  Plan du Scénario: Créer un catalogue de besoins
    Quand je me connecte avec mon username "<username>" et mot de passe "<password>"
    Alors la page "<titre>" s'affiche
    Et mon XFR est présent dans le header

    Exemples:
      |username  | password | titre             |
      |XFR7284002|auchan    |Bienvenue dans Animco Appel d'offres !|