#language: fr
@regression
Fonctionnalité: Connexion dans AnimCo AO
  En tant qu'utilisateur
  Je souhaite me connecter dans l'outil Animco AO
  Afin d'utiliser les fonctionnalités de l'outil

  Contexte:
    Etant donné que j'ai saisi l'url  "https://animco-appel-offres.qualif.fr.auchan.com/home"
    Alors je suis redirigé vers le CAS "Authentication Service"

  Plan du Scénario: Connexion avec des identifiants valides
    Quand je me connecte avec mon username "<username>" et mot de passe "<password>"
    Alors la page "<titre>" s'affiche
    Et mon XFR est présent dans le header

    Exemples:
      |username  | password | titre             |
      |XFR7284002|auchan    |Bienvenue dans Animco Appel d'offres !|