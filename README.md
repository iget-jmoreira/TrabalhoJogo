# Game-Tetris #
- Game em **JAVA** baseado no jogo Tetris utilizando Swing.

## Description ##
Desenvolvido em 2015 por aluno de **Ciências da Computação** da `Universidade de Fortaleza (UNIFOR)`. 
Disciplina de `Técnicas de Programação` do terceiro semestre do curso.

* utilização de Java para desktop
* utilização de Threads
* utilização de Swing
* utilização de Database MySql com o `XAMPP`
* utilização do **mysql connector 5.0.8** (`project_name>Build Path>Add External Archives>arquivo`)

## Database *game* ##

#### Table: `users` ####
Column | Type | Foreign Key | Null
---|---|---|---
 *id* | int | false | false
*username* | varchar (255) | false | false
*password* | varchar (255) | false | false
*email* | varchar (255) | false | false
*question* | varchar (255) | false | false
*answer* | varchar (255) | false | false

#### Table: `records`  ####
Column | Type | Foreign Key | Null
---|---|---|---
*id* | int | false | false
*username* | varchar (255) | false | false
*score* | decimal (11,2) | false | false
*date* | varchar(50) | false | false
