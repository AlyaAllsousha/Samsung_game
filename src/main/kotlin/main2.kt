import java.awt.Color
import java.util.Scanner
import kotlin.math.abs
import kotlin.random.Random

fun main() {

    println("Первый игрок: 1 - волшебник, 2 - робот, 3 - рыцарь: ")
    val scan = Scanner(System.`in`)
    val type1: Int = scan.nextInt()
    println("Cила персонажа: ")
    val power1: Double = scan.nextInt().toDouble()
    lateinit var player1: Human
    when (type1) {
        1 -> {
            println("Введите ману волшебника от 1 до 15: ")
            var mana = scan.nextInt().toDouble()
            if (mana > 15 || mana < 0)
                mana = 15-abs(mana)%15
            player1 = Wizard(power = power1, type = type.Wizard, mana = mana)
        }

        2 -> {
            println("Введите заряд робота от 1 до 100: ")
            var battery = abs(scan.nextInt().toDouble()) % 101
            player1 = Robot(power = power1, type = type.Robot, battery = battery)

        }

        3 -> {
            println("Введите защиту рыцаря от 1  до 10")
            var deff = abs(scan.nextInt().toDouble()) % 11
            player1 = knight(power = power1, type = type.Knight, defence = deff)
        }
    }

    println("Второй игрок: 1 - волшебник, 2 - робот, 3 - рыцарь: ")
    val type2: Int = scan.nextInt()
    println("Cила персонажа: ")
    val power2: Double = scan.nextInt().toDouble()
    lateinit var player2: Human
    when (type2) {
        1 -> {
            println("Введите ману волшебника от 1 до 15: ")
            var mana = scan.nextInt().toDouble()
            if (mana > 15 || mana < 0)
                mana = 15-abs(mana)%15
            player2 = Wizard(power = power2, type = type.Wizard, mana = mana)
        }

        2 -> {
            println("Введите заряд робота от 1 до 100: ")
            var battery = abs(scan.nextInt().toDouble()) % 101 / 100
            player2 = Robot(power = power2, type = type.Robot, battery = battery)

        }

        3 -> {
            println("Введите защиту рыцаря от 1  до 10")
            var deff = abs(scan.nextInt().toDouble()) % 11
            player2 = knight(power = power2, type = type.Knight, defence = deff)
        }
    }

    println("Третий игрок: 1 - волшебник, 2 - робот, 3 - рыцарь: ")
    val type3: Int = scan.nextInt()
    println("Cила персонажа: ")
    val power3: Double = scan.nextInt().toDouble()
    lateinit var player3: Human
    when (type3) {
        1 -> {
            println("Введите ману волшебника от 1 до 15: ")
            var mana = scan.nextInt().toDouble()
            if (mana > 15 || mana < 0)
                mana = 15-abs(mana)%15
            player3 = Wizard(power = power3, type = type.Wizard, mana = mana)
        }

        2 -> {
            println("Введите заряд робота от 1 до 100: ")
            var battery = abs(scan.nextInt().toDouble()) % 101 / 100
            player3 = Robot(power = power3, type = type.Robot, battery = battery)

        }

        3 -> {
            println("Введите защиту рыцаря от 1  до 10")
            var deff = abs(scan.nextInt().toDouble()) % 11
            player3 = knight(power = power3, type = type.Knight, defence = deff)
        }
    }

    player1.checkPower(player1.power)
    player2.checkPower(player2.power)
    player3.checkPower(player3.power)
    println(player1.toString())
    println(player2.toString())
    println(player3.toString())
    println("Игра начинается!")
    var players = arrayOf(player1, player2, player3)
    var fl = 0
    var dam = 0.0
    var hp = 0.0
    var a = 0
    var b= 0
    while (player1.health > 0 || player2.health >0 || player3.health > 0) {
        val is_alive = Array(3, {i ->(if(players[i].health>0) 1 else 0)})
        if(is_alive.sum() == 1){
        println("Победил игрок ${is_alive.indexOf(1) + 1}")
            break
        }
        println("Введите номера сражающихся игроков")
        a = (scan.nextInt()-1) % 3
        b= (scan.nextInt()-1) %3

        if (players[a].health > 0 && players[b].health > 0) {
            println("Игроки ${a+1} и игрок ${b+1} атаковали друг друга ")
            dam = (Random.nextDouble(0.0, 1.0))
            println("Игрок ${a + 1} нанес урон игроку ${b + 1}: $dam ")
            players[a].attack(dam, players[b])
            println("Игрок ${b + 1}: ${players[b].toString()}")
            if (players[b].health <= 0) {
                println("Игрок ${b + 1} умер")
            } else {
                players[b].heal(Random.nextDouble(0.0, 50.0))
                dam = (Random.nextDouble(0.0, 1.0))
                println("Игрок ${b + 1} нанес урон игроку ${a + 1}: $dam ")
                players[b].attack(dam, players[a])
                println("Игрок ${a + 1}: ${players[a].toString()}")
                if (players[a].health <= 0) {
                    println("Игрок ${a + 1} умер")
                } else {
                    players[a].heal(Random.nextDouble(0.0, 50.0))
                }
            }
            println("Результат: ")
            println("Игрок ${a + 1}: ${players[a].toString()}")
            println("Игрок ${b + 1}: ${players[b].toString()}")
            println("\n")
        }
    }
}




