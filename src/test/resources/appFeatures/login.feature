#language: fr
@regression
Fonctionnalité: Connexion dans AnimCo AO
  En tant qu'utilisateur
  Je souhaite me connecter dans l'outil Animco AO
  Afin d'utiliser les fonctionnalités de l'outil

  Contexte:
    Etant donné que je suis sur le CAS Auchan Klif "https://casqualif.auchan.com/"
    Alors le titre de la page est "AUCHAN Authentication Service"

  Plan du Scénario: Connexion avec des identifiants valides
    Quand je renseigne mon identifiant "<username>"
    Et que je renseigne mon Mot de passe "<password>"
    Et que je clique sur le bouton Se Connecter
    Alors je vois le titre de la page d'accueil "Animco Appel d'offres"

    Exemples:
      |username  | password |
      |XFR728400 | auchan   |