import kotlin.math.abs

abstract class Human(
      var health: Double,
     var power: Double,
     var type:type
):Iheal {
    companion object{
        @JvmStatic
        protected val healthMax:Double = 100.0
    }
    abstract fun attack( damage:Double, person:Human)
    fun checkPower(powerNum:Double){
        if (powerNum > 80 || powerNum < 1)
            this.power = abs(powerNum)%80

        else
            this.power = powerNum
    }


}