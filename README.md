# TP Pokémon : dresseurs et arènes

Un TP Java fait pendant la formation (Ada Tech, Bloc 2) pour pratiquer la **programmation orientée objet**,
de la première classe jusqu'à **l'héritage**.

Des Pokémon s'affrontent, des dresseurs (explorateurs, apprentis et maîtres d'arène) se défient, et chaque
type (Feu, Eau, Plante, Électrique…) a ses forces et ses faiblesses.

```
=== Explorateur Sacha, de Bourg Palette (0 badge(s))  VS  Maître Ondine de l'arène Azuria, spécialiste Eau (0 défense(s) réussie(s)) ===
  Salamèche (force 58) affronte Stari (force 220) : Stari gagne !
  Bulbizarre (force 220) affronte Stari (force 65) : Bulbizarre gagne !
>>> Sacha remporte le combat !
Sacha obtient le Badge Azuria !
```

📄 Le sujet complet : [tp-pokemon.md](src/main/resources/tp-pokemon.md)
📚 Le cours associé : [cours-heritage-java.md](src/main/resources/cours-heritage-java.md)

---

## Prérequis

- **JDK 25** (le `pom.xml` compile en Java 25)
- **Maven** 3.x

Pour vérifier : `java -version` et `mvn -version`.

## Lancer le projet

Depuis la racine du projet :

```bash
# 1. Compiler
mvn compile

# 2. Lancer un fichier de vérification
java -cp target/classes com.spedev.fullstack.MainPartie3
```

Il y a trois fichiers de vérification, un par partie du TP :

| Fichier | Étapes vérifiées |
|---|---|
| `MainPartie1et2` | 1 à 5 : Pokémon, dresseurs, combats |
| `MainPartie3` | 6 à 9 : types, héritage, factorisation des dresseurs |
| `MainPartie4` | 10 à 13 : `static`, `enum`, attaques, dés |

Chaque vérification affiche `OK` ou `ÉCHEC`, puis un bilan à la fin. Pour activer une étape, décommentez son
appel dans `main()` et la méthode correspondante.

> 💡 **Accents mal affichés dans le terminal Windows ?** Passez la console en UTF-8 avant de lancer :
> `chcp 65001` (cmd / PowerShell), ou ajoutez `-Dstdout.encoding=UTF-8` à la commande `java`.

---

## Structure du code

Tout est dans le package `com.spedev.fullstack` ([src/main/java/com/spedev/fullstack/](src/main/java/com/spedev/fullstack/)).

| Classe | Rôle |
|---|---|
| `Pokemon` | classe **abstraite** : nom, niveau, puissance, K.O., combat entre deux Pokémon |
| `PokemonFeu`, `PokemonEau`, `PokemonPlante`, `PokemonElectrique` | les types du sujet : faiblesses, résistances, talents |
| `PokemonNormal`, `PokemonPsy`, `PokemonVol` | types supplémentaires |
| `Dresseur` | **interface** : ce que sait faire n'importe quel dresseur |
| `DresseurAbstrait` | classe **abstraite** : le code commun à tous les dresseurs (équipe, capture, soin…) |
| `Explorateur` | gagne des badges en battant des maîtres d'arène |
| `ApprentiArene` | équipe de 3 Pokémon, indique le chemin vers son maître quand il perd |
| `MaitreArene` | a une spécialité (un type), offre un badge, compte ses défenses réussies |
| `Combat` | fait s'affronter deux dresseurs jusqu'à ce que l'un n'ait plus de Pokémon debout |
| `EquipePleineException` | exception **vérifiée** levée quand l'équipe est complète |
| `MainPartie*` | programmes de vérification fournis avec le sujet |
| `Main` | point d'entrée libre, pour expérimenter |

### La hiérarchie

```
           «interface»                         «abstraite»
            Dresseur                             Pokemon
               ▲                                    ▲
               │ implements                         │ extends
       «abstraite»                ┌──────────┬──────┴─────┬──────────────┐
     DresseurAbstrait          PokemonFeu PokemonEau PokemonPlante PokemonElectrique …
               ▲
               │ extends
   ┌───────────┼─────────────┐
Explorateur ApprentiArene MaitreArene
```

`Combat` ne connaît que l'interface `Dresseur` : il fonctionne avec toutes les sortes de dresseurs,
même celles qui n'existent pas encore.

---

## Avancement

| Partie | Contenu | État |
|---|---|---|
| 1. Les Pokémon | classe, constructeur, encapsulation, `toString` | ✅ |
| 2. Les dresseurs | interface, polymorphisme, composition, exception | ✅ |
| 3. Les types | classe abstraite, `extends`, `super`, redéfinition | ✅ |
| 4. Pour aller plus loin | `static`, `enum`, objet immuable, `equals` / `hashCode`, faux objets | ⬜ à faire |
| Bonus | points de vie, nouveau type, champion, objets, stratégies… | ⬜ |

---

## Notions travaillées

- **Encapsulation** : attributs `private`, règles protégées (niveau entre 1 et 100, taille d'équipe…)
- **Interface** et **polymorphisme** : une `List<Dresseur>` où chaque dresseur répond à sa façon
- **Composition** : un dresseur *a* une équipe (`List<Pokemon>`), dont le getter renvoie une copie
- **Exceptions** : `IllegalArgumentException`, `IllegalStateException`, et une exception vérifiée maison
- **Classe abstraite** et **héritage** : `extends`, `super(...)`, `@Override`, méthode abstraite ou redéfinissable
- **`super.methode()`** : compléter le comportement de la classe mère (talents Brasier et Croissance)

Le tableau complet se trouve à la fin du [sujet](src/main/resources/tp-pokemon.md#récapitulatif--où-sont-les-notions-).
