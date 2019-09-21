@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    var b = age
    if (age > 100 && age < 121) {
        b = age % 100
    }
    return when {
        b == 1 -> "$age год"
        b == 2 -> "$age года"
        b == 3 -> "$age года"
        b == 4 -> "$age года"
        b >= 5 && b <= 20 -> "$age лет"
        b % 10 == 1 -> "$age год"
        b % 10 == 2 -> "$age года"
        b % 10 == 3 -> "$age года"
        b % 10 == 4 -> "$age года"
        else -> "$age лет"
    }
}

/*fun main() {
 ageDescription(201)
}
*/
/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
    val s = v1 * t1 + v2 * t2 + v3 * t3
     when {
        v1 * t1 > s / 2 -> return s / 2 / v1
        v1 * t1 + v2 * t2 > s / 2 -> return (s / 2 - v1 * t1) / v2 + t1
        v1 * t1 + v2 * t2 + v3 * t3 > s / 2 -> return (s / 2 - v1 * t1 - v2 * t2) / v3 + t1 + t2
        }

}


/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    var b = 0
    if (kingX == rookX1 || kingY == rookY1) b = b + 1
    if (kingX == rookX2 || kingY == rookY2) b = b + 2
    return if (b == 1) 1 else if (b == 2) 2 else if (b == 3) 3 else 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int {
    var b = 0
    if (kingX == rookX || kingY == rookY) b = b + 1
    if (abs(kingX - bishopX) == abs(kingY - bishopY)) b = b + 2
    return if (b == 1) 1 else if (b == 2) 2 else if (b == 3) 3 else 0
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    var a1 = max(a, b)
    var a2 = max(b, c)
    var a3 = max(a, c)
    if (a1 == a2) {
        a1 = b
        a2 = a3
        a3 = min(a, c)
    } else if (a2 == a3) {
        a2 = a1
        a1 = c
        a3 = min(a, b)
    } else if (a1 == a3) {
        a1 = a
        a3 = min(c, b)
    }
    return if (a2 + a3 < a1) -1
    else if (a2 * a2 + a3 * a3 > a1 * a1) 0
    else if (a2 * a2 + a3 * a3 == a1 * a1) 1
    else 2
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    var long = 0

    if (b < c || a > d) long = -1
    else if (b == c || a == d) long = 0
    else if (a <= c && b <= d) long = b - c
    else if (a <= c && d <= b) long = d - c
    else if (a >= c && d <= b) long = d - a
    else if (a >= c && d >= b) long = b - a
    return long
}

