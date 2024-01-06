### 1. JFrame
- `JFrame` ist das grundlegende Fenster, in dem Ihre GUI-Komponenten angezeigt werden. Es dient als Hauptfenster für Ihre Anwendung.
- Es kann Menüleisten enthalten, Titel festlegen, Größe und Standardverhalten beim Schließen definieren.

### 2. JRootPane
- Jeder `JFrame` enthält eine Instanz von `JRootPane`.
- `JRootPane` ist ein Container, der mehrere Ebenen organisiert, darunter das `contentPane`, `glassPane`, und optional ein `JMenuBar`.

### 3. JLayeredPane
- Im `JRootPane` befindet sich das `JLayeredPane`, das verschiedene "Ebenen" oder "Layer" zur Anordnung von GUI-Komponenten bietet.
- Es ermöglicht, dass einige Komponenten über anderen schweben, was nützlich ist für Dinge wie Pop-up-Menüs oder Drag-and-Drop-Funktionen.

### 4. Content Pane
- Das `contentPane` ist der Hauptcontainer in `JRootPane`, in den Ihre GUI-Komponenten wie Buttons, Textfelder, Panels etc. platziert werden.
- Es ist in der Regel ein `JPanel`, das das Layout und die Anordnung der hinzugefügten Komponenten verwaltet.

### 5. JMenuBar
- `JMenuBar` ist eine Komponente, die in `JFrame` eingefügt werden kann, um Menüs zu erstellen.
- Sie kann mehrere `JMenu`-Objekte enthalten, die wiederum `JMenuItem`-Objekte enthalten, um ein Dropdown-Menüsystem zu erstellen.

### 6. Glass Pane
- Das `glassPane` ist eine Ebene, die über allen anderen Komponenten des `JRootPane` liegt.
- Es kann genutzt werden, um globale Maus-Events zu erfassen oder um eine Anwendung zu blockieren, indem eine "Glasscheibe" über die gesamte Anwendung gelegt wird.