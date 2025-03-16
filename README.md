# MowItNow - Tondeuse automatique

Ce projet est une implémentation en Java du kata "MowItNow". Il permet de contrôler des tondeuses automatiques déployées sur une pelouse rectangulaire, en suivant les instructions fournies dans un fichier d'entrée.

## Prérequis
- Java 21 ou version ultérieure
- Maven 3.9.0 ou version ultérieure


## Installation

1. Cloner le dépôt Git
```bash
git clone https://github.com/Nielk74/kata-tondeuse.git
```

2. Se rendre dans le répertoire du projet
```bash
cd kata-tondeuse
```

3. Compiler le projet
```bash
mvn clean install compile
```

## Utilisation

1. Un fichier exemple se trouve à la racine du projet : `input.txt`. Il contient les instructions pour une pelouse de 5x5 et deux tondeuses.

2. Exécuter le programme
```bash
mvn exec:java -Dexec.args="input.txt"
```

## Tests

Pour exécuter les tests unitaires, lancer la commande suivante :
```bash
mvn test
```