@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1


import lesson1.task1.sqr
import java.lang.Math.pow
import kotlin.math.*


private val Double.kotlin: Any
    get() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var n1 = abs(n)
    var count = if (n1 == 0) 1 else 0
    while (n1 > 0) {
        count++
        n1 /= 10
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var n1 = n
    var f1 = 0
    var f2 = 1
    var a = f2
    while (n1 - 1 > 0) {
        a = f2
        f2 += f1
        f1 = a
        n1 -= 1
    }
    return f2
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var n1 = n
    var m1 = m
    while (n1 != 0 && m1 != 0) {
        if (m1 > n1) m1 %= n1
        else
            n1 %= m1
    }
    return n * m / (n1 + m1)
}

/*{
    var k = 1
    var a2 = 0
    var b2 = 0
    var a3 = 0
    var b3 = 0
    var a5 = 0
    var b5 = 0
    var a7 = 0
    var b7 = 0
    var m1 = m
    var n1 = n
    if (n1 == m1)
        return m1
    else {
        while (m1 %2 == 0 || n1 %2== 0) {
            if (m % 2 == 0) {
                a2 += 1
                m1 /= 2
            }
            if (n % 2 == 0) {
                b2 += 1
                n1 /= 2
            }
        }
        if (a2 > 0 || b2 > 0) k *= max(a2, b2) * 2
        while (m1 %3 == 0 || n1 %3== 0) {
            if (m % 3 == 0) {
                a3 += 1
                m1 /= 3
            }
            if (n % 3 == 0) {
                b3 += 1
                n1 /= 3
            }
        }
        if (a3 > 0 || b3 > 0) k *= max(a3, b3) * 3
        while (m1 %5 == 0 || n1 %5==0) {
            if (m % 5 == 0) {
                a5 += 1
                m1 /= 5
            }
            if (n % 5 == 0) {
                b5 += 1
                n1 /= 5
            }
        }
        if (a5 > 0 || b5 > 0) k *= max(a5, b5) * 5
        while (m1 %7==  0 || n1 %7== 0) {
            if (m % 7 == 0) {
                a7 += 1
                m1 /= 7
            }
            if (n % 7 == 0) {
                b7 += 1
                n1 /= 7
            }
        }
        if (a7 > 0 || b7 > 0) k *= max(a7, b7) * 7
        k *= n1 * m1
        return k
    }
}
*/

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..n / 2)
        if (n % i == 0) {
            return i
        }
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    for (i in n / 2 downTo 2)
        if (n % i == 0) {
            return i
        }
    return 1
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var n1 = n
    var m1 = m
    var k = 0
    while (n1 != 0 && m1 != 0) {
        if (m1 > n1) m1 %= n1
        else {
            n1 %= m1
        }
        if (m1 == 1 || n1 == 1) {
            k = 200
            break
        }
        if (m1 != 0 && n1 != 0) k += 1
        if (k > 100) break
    }
    return k > 100
}
/*
fun main() {
    println(isCoPrime(50001,36744))
}*/
/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var m1 = sqrt(m.toDouble())
    var n1 = sqrt(n.toDouble())
    val m2 = m.toDouble()
    val n2 = n.toDouble()
    m1 = floor(m1)
    n1 = floor(n1)
    return when {
        m == n -> true
        m2 == sqr(m1) -> true
        n2 == sqr(n1) -> true
        abs(n1 - m1) > 0 -> true
        else -> false
    }
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var f = x
    var k = 0
    while (f != 1) {
        f = if (f % 2 == 0) f / 2
        else
            3 * f + 1
        k += 1
    }
    return k
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var a = 100.0
    var y = abs(x)
    var n = 3
    var k1 = x / y
    var k = 1
    var y1 = 0.0
    if (x == 0.0) return 0.0
    if (x / PI % 2 == 0.0) return 0.0
    while (y > 2.0 * PI) {
        y -= 2.0 * PI
    }
    y = k1 * y
    y1 = y
    do {
        a = pow(y1, n.toDouble()) / factorial(n)
        if (k % 2 == 1) y -= a
        else y += a
        k++
        n += 2
    } while (abs(a) > eps)
    return y - a
}
/*
fun main() {
    println(sin(-18.832102629018816,1e-10))
}
0.017452406459518247
0.017452406459518247
*/
/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var a = 100.0
    var y = abs(x)
    var n = 2
    var k1 = x / y
    var k = 1
    var y1 = 0.0
    if (x == 0.0) return 1.0
    if (x / PI % 2 == 0.0) return 1.0
    while (y > 2.0 * PI) {
        y -= 2.0 * PI
    }
    y1 = k1 * y
    y = 1.0
    do {
        a = pow(y1, n.toDouble()) / factorial(n)
        if (k % 2 == 1) y -= a
        else y += a
        k++
        n += 2
    } while (abs(a) > eps)
    return y + a
}
/*
fun main() {
    println(cos(-18.832102629018816, 1e-10))
}
0.9998476951604843
0.9998476951604843
*/
/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var n1 = n
    var k = 0
    var result = 0
    var j = 0
    while (n1 > 0) {
        n1 /= 10
        k += 1
    }
    n1 = n
    while (n1 > 0) {
        result += n1 % 10 * pow(10.toDouble(), (k - j - 1).toDouble()).toInt()
        j += 1
        n1 /= 10
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var n1 = n
    var k = 0
    var k1 = 0
    var j = 0
    if (n == 0) return true
    while (n1 > 0) {
        n1 /= 10
        k++
    }
    if (k == 1) return true
    k1 = k
    if (k % 2 == 1) k -= 1
    for (i in 1..k / 2) {
        if (n / pow(10.0, i.toDouble() - 1.0).toInt() % 10 == n / pow(10.0, k1.toDouble() - i).toInt() % 10)
            j++
        else
            break
    }
    return j == k / 2
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val x = n % 10
    var k = 1
    var n1 = n
    var j = 0
    while (n1 > 0) {
        n1 /= 10
        j++
    }
    if (n == 0) return false
    if (j == 1) return false
    n1 = n
    while (n1 > 0) {
        n1 /= 10
        if (n1 % 10 == x) k++
        else break
    }
    return j != k
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var k = 1
    var k1 = 0
    var a = 1
    var i = 1
    var j = 0

    while (k1 < n) {
        if (k1 == n) break
        j = 0
        k = i * i
        while (k > 0) {
            k /= 10
            j++
        }
        k = i * i
        i++
        while (j > 0) {
            a = k / pow(10.0, (j - 1).toDouble()).toInt() % 10
            k1++
            k %= pow(10.0, (j - 1).toDouble()).toInt()
            j--
            if (k1 == n) break
        }
    }
    return a
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var k = 1
    var k1 = 0
    var a = 1
    var i = 1
    var j = 0

    while (k1 < n) {
        if (k1 == n) break
        j = 0
        k = fib(i)
        while (k > 0) {
            k /= 10
            j++
        }
        k = fib(i)
        i++
        while (j > 0) {
            a = k / pow(10.0, (j - 1).toDouble()).toInt() % 10
            k1++
            k %= pow(10.0, (j - 1).toDouble()).toInt()
            j--
            if (k1 == n) break
        }
    }
    return a
}

