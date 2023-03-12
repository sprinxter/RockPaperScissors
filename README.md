# Rock Paper Scissors
#### Game Rules
* There should be more than 1 player in the game.
* If there are 2 players, then clearly win/lose/draw can be decided.
* If there are more than 2 players, 
  * If no. of distinct moves are 1 or >2, then all DRAW.
  * if no. of distinct moves are 2, we can clearly decide the group of winners and losers.

#### GamePlay
* It will ask you no. of robot and no. of human players.
  * Input numbers like "3 5" and press Enter.
* It will ask the names of robots and humans 1 by 1. Names can repeat.
  * Press "<Name>" and press Enter.
* Once the game starts, in each match:
  * It will first choose robot moves randomly. And asks human moves 1 by 1.
  * Eg: press "Rock" and Press Enter. (Move names are Case insensitive.)
  * After all human moves are entered, it will show who are the winners if winning is possible.
  * Else, it will say it's a draw.
  * You will be prompted to type y or n to continue or exit the game.
* Once you exit the game, it will show player wise statistics.
* Happy Playing!

#### Note
**There can be more than rock, paper and scissors. For this version, there are only these 3.**

**But it is built in a scalable way, we can add more moves in PlayerMove ENUM class and fill in the map of win-lose-draw. The rest of the code will handle it automatically.**
