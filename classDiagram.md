# Class Diagram
```mermaid
classDiagram
a <|-- b

Tool <|-- Gun
Tool <|-- Axe
Tool <|-- Hammer
Tool <|-- Pick
Tool <|-- Hook

class Playmat{
    -int day
    -Animal huntingGround[2]
    -Dice dice
    -int score

    +dayPass() void
}

class Player{
    -int HP
    -int energy

    +eat(int food) void
}

class Part{
    -String name
    -boolean fixed
    -Resource requirement

    +fix() void
}

class Resource{
    -String name
    -int amount

    +setName() void
    +getName() String
    +setAmount() void
    +getAmount() int
}

class Sector{
    -String name
    -int pips
    -Resource resource

    +discover() void
    +gather() void
}

class Animal{
    -String name
    -int rating
    -int foodDrop
    -int damage

    +hunting(Player p) int
}

class Dice{
    -int face
    -int max

    +roll(int amount)
}

class Tool{
    <<Abstract>>
    -String name
    -int targetNumber
    -Sector sectorRequirement
    -boolean obtained

    +ability()* void
}

class Gun{
    +void ability()
}

class Axe{
    +void ability()
}

class Hammer{
    +void ability()
}

class Pick{
    +void ability()
}

class Hook{
    +void ability()
}

```

# Game Flow

```mermaid
flowchart TD

Upkeep --> Draw --> os["Order (start)"]

oe["Order (end)"]

os --> es["Explore (start)"]
os --> hs["Hunting (start)"]
os --> gs["Gather (start)"]
os --> cs["Construction (start)"]
os --> rs["Rest (start)"]
os --> fs["Fix (start)"]

es --> ee["Explore (end)"]
hs --> he["Hunting (end)"]
gs --> ge["Gather (end)"]
cs --> ce["Construction (end)"]
rs --> re["Rest (end)"]
fs --> fe["Fix (end)"]

ee --> oe
he --> oe
ge --> oe
ce --> oe
re --> oe
fe --> oe

oe --> eat["Eat"]

eat --> turnEnd["Turn End"]
```

## Upkeep

```mermaid
flowchart TD

0(start)
1{hook.obtained == true}
2{"dice.roll() >= 2"}
3[food += 1]
-1(end)

0 --> 1
1 --yes--> 2
1 --no--> -1
2 --yes--> 3
2 --no--> -1
3 --> -1
```

## Draw

```mermaid
flowchart TD

0(start)
1["playmat.drawAnimal(2)"]
-1(end)

0 --> 1 --> -1
```

## Order

### Explore

```mermaid
flowchart TD

0(start)
1["choose N dice"]
2{"dice.roll(N) >= 4"}
3["sector.explored()"]
-1(end)

0 --> 1
1 --> 2
2 --yes--> 3
3 --> -1
2 --no--> -1

```

### Hunting

```mermaid
flowchart TD

0(start)
1["choose N dice"]
2[choose available animal]
3{"dice.roll(N) >= animal.rating()"}
4["food += animal.getfoodDrop()"]
5["animal.discard()"]
6["player.HP() -= animal.damage()"]
7{"gun.obtained()"}
8["dice += 1"]
-1(end)

0 --> 1
1 --> 7
7 --yes--> 8
8 --> 2
7 --no--> 2
2 --> 3
3 --yes--> 4
4 --> 5
5 --> -1
3 --no--> 6
6 --> -1

```

### Gather

```mermaid
flowchart TD

0(start)
1(choose discovered sector)
2(choose N dice)
3{"dice.roll(N) >= 3"}
4["resource += sector.resource()"]
-1(end)

0 --> 1
1 --> 2
2 --> 3
3 --yes--> 4
4 --> -1
3 --no--> -1

```

### Construction

```mermaid
flowchart TD

0(start)
1[choose gadget]
2{"gadget.sectorRequirement().discovered"}
3[choose N dice]
4{"dice.roll(N) >= gadget.targetNumber()"}
5["gadget.obtained() == true"]
-1(end)

0 --> 1
1 --> 2
2 --yes--> 3
2 --no--> 1
3 --> 4
4 --yes--> 5
4 --no--> -1
5 --> -1

```

### Rest

```mermaid
flowchart TD

0(start)
1["choose N dice"]
2["player.rest(N)"]
-1(end)

0 --> 1 --> 2 --> -1
```

### Fix

```mermaid
flowchart TD

0(start)
1{check part requirement}
2[reduce resource]
3["part.fixed()"]
-1(end)

0 --> 1
1 --yes--> 2
1 --no--> -1
2 --> 3
3 --> -1

```

## Eat

```mermaid
flowchart TD

0(start)
1[how many food]
2[set dice]
-1(end)

0 --> 1
1 --> 2
2 --> -1

```

## Turn End

```mermaid
flowchart TD

0(start)
1["playmat.day += 1"]
-1(end)

0 --> 1 --> -1
```

# Screen

## Ship

- Resources
- Gadgets
- Fixing
- Rest

## Sector

- Explore
- Gather

## Hunting Ground

- Hunting


