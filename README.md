# 🔗 Altklausur 2022FT – Graphstruktur & Pfadsuche

Dieses Projekt enthält eine vollständige Lösung zur **Altklausur 2022FT** im Rahmen der objektorientierten Programmierung.

## 📁 Struktur

Der relevante Code liegt im Verzeichnis `src/`:

- **`GraphItem`** – Abstrakte Oberklasse für Knoten (`Node`) und Kanten (`Edge`).
- **`Node`** – Repräsentiert Knoten im Graphen.
- **`Edge`** – Verbindet zwei Knoten miteinander.
- **`Graph`** – Stellt ein gesamtes Netz von Knoten und Kanten dar.
- **`Path`** – Modelliert einen Pfad innerhalb des Graphen.
- **`Main`** – Dient zum manuellen Testen oder Ausprobieren.
- **`PathTest`** – Testklasse mit Beispielen und Funktionsprüfungen.

## ✅ Hinweise zur Bearbeitung

- Führt **`PathTest`** aus, um die korrekte Implementierung zu überprüfen.
- Alle Aufgaben aus der Klausur wurden implementiert und lassen sich anhand der Tests nachvollziehen.
- Die Pfadlogik (`Path`) ist besonders zentral für das Verständnis der zugrundeliegenden Algorithmen.

## 📚 Empfehlung

- Untersucht zuerst den Aufbau der `GraphItem`-Vererbung.
- Schaut euch dann die `Graph`-Struktur und wie `Edges` und `Nodes` darin organisiert sind an.
- Nutzt die Testfälle in `PathTest`, um eure Änderungen zu überprüfen oder zu erweitern.

---

Viel Erfolg beim Verstehen und Durcharbeiten der Altklausur!
