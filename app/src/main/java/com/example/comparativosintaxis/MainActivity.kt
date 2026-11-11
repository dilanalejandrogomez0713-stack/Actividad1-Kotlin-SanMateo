
package com.example.comparativosintaxis

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nombreEstudiante: String = "Carlos Pérez"
        val carrera: String = "Ingeniería de Sistemas"
        val asignatura: String = "Programación para Dispositivos Móviles"

        var notaCorte1: Double = 4.2
        var notaCorte2: Double = 3.5
        var notaCorte3: Double? = null

        val notaFinal3 = notaCorte3 ?: 0.0

        val promedio = calcularPromedio(
            notaCorte1,
            notaCorte2,
            notaFinal3
        )

        val reporte = generarReporte(
            nombreEstudiante,
            carrera,
            asignatura,
            promedio
        )

        val txtContador = findViewById<TextView>(R.id.txtContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        txtContador.text = reporte
        txtContador.textSize = 16f
        btnAumentar.visibility = android.view.View.GONE

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

fun calcularPromedio(n1: Double, n2: Double, n3: Double): Double =
    (n1 + n2 + n3) / 3

fun generarReporte(
    estudiante: String,
    carrera: String,
    materia: String,
    promedio: Double
): String {

    val estado = if (promedio >= 3.0) "APROBADO" else "REPROBADO"

    return """
        Estudiante: $estudiante
        Carrera: $carrera
        Materia: $materia
        Promedio: ${String.format("%.2f", promedio)}
        Estado: $estado
    """.trimIndent()
}
