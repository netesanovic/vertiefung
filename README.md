# Mobile Test Frameworks

## Was ist ein Framework
Frameworks dienen als Grundlage um bestimmte Sachen zu implementieren. Zum Beispiel kann das Framework Bootstrap von Twitter genutzt werden um eine Basis für das Design zu haben. Auf diese kann dann weiter aufgebaut werden, um das Design zu personalisieren.
Solche Fundamente wurden schon für viele verschiedene Verwendungszwecke entwickelt. Zu diesen zählen, zum Beispiel:
* Application Frameworks
* Web Frameworks
* Test Frameworks
* ...

## Beschreibung
Innerhalb der Vertiefung werden nur Test Frameworks berücksichtigt, welche für die Testung von mobilen Applikationen auf Android und iOS genutzt werden.

### Leitfragen

Folgende Fragen sollen beantwortet werden:

* Welche Test Frameworks existieren für mobile Applikationen? (Vorteile/Nachteile)
* Welche Teile der Applikation können mit diesen getestet werden bzw. Was wird von diesen Frameworks getestet?
* Wie erstelle ich die Tests? Wie führe ich sie aus? Wie werden die Ergebnisse angezeigt? (Beispiele)

## Overleaf
[Latex Protokoll](https://www.overleaf.com/read/xzsmcybkbnvd)

## Unit Tests ausführen

Bevor man die Tests ausführen kann, muss man den Seicherort der Android-Sdk festlegen, entweder innerhalb der **local.properties** im Root-Folder des Projektes unter dem Attribut **sdk.dir** (Beispiel in Windows: sdk.dir=C\:\\Users\\Nemanja\\AppData\\Local\\Android\\Sdk), oder mithilfe einer Umgebnungsvariable unter dem Namen ANDROID_HOME.

Um die Unit Tests auszuführen, kann man den Command ```gradle test``` benutzen. Eine html-Datei mit den Testresultaten ist unter **path_to_project/module_name/build/reports/tests**. Eine xml-Datei mit den Testresultaten ist unter **path_to_project/module_name/build/test_results**.

## Probleme

Beim Switch-Case habe ich die Breaks vergessen. Erst nachdem ich mit den Unit Tests die Operations überprüft habe und dann mit dem Debugger durchgegangen bin, habe ich beim Weiterschalten gemerkt, dass immer alle Operationen durchgeführt wurden. :)

Ich wollte Travis für die Continuous Integration meines Projektes nutzen, allerdings bekam ich am Anfang immer den Fehler, dass die genutzte Gradle Version niedriger war als die Minimum Supported Version. Den Fehler habe ich behoben, indem ich in der **build.gradle** im Root-Verzeichnis des Projektes die 

Nachdem ich keine Fehler mehr von der Gradle Version bekommen habe, habe ich einen Lint-Fehler erhalten. Um herauszufinden, welche diese waren, benutzte ich den Befehl ```gradle app:lint (--stacktrace)```. Daraufhin werden auch eine HTML- und eine XML-Datei erstellt, welche einem die jeweiligen Fehler zeigt. Diese befinden sich unter **path_to_project/module_name/build/reports**. Die Fehler welche ich ausbessern musste waren folgende:
* ButtonStyle: Hierfür habe ich zu den Buttons ```style="?android:attr/buttonBarButtonStyle"/>``` hinzugefügt und im LinearLayout, welche die Buttons beinhaltet ```style="?android:attr/buttonBarStyle"``` hinzugefügt.
* HardcodedText: Statt bei den Buttons innerhalb des text-Attributs einfach Texte reinzuschreiben, sollte man innerhalb der **strings.xml** die Texte definieren ```<string name="[samplename]">/</string>``` und dann bei den Buttons folgendermaßen zu nutzen: ```@strings/[sample_name]```.
* LabelFor: Hier habe ich zu den EditText Feldern das Attribut labelFor hinzugefügt -> ```android:labelFor="@+id/[id_des_edittexts]"```
* AllowBackup: allowbackup bzw. hier allow full backup content
* GoogleAppIndexingWarning: action view hinzufügen -> missing url
* IconLauncherFormat: Lint erlaubt keine Icons die nicht PNGs sind. Aufgrund dessen habe ich die automatisch generierten XML-Dateien bzw. die Ordner 
* GradleDependency

Nachdem ich die alle Lint-Fehler ausgebessert habe, bekam ich dennoch einen Lint-Fehler auf Travis. Aufgrund dessen habe ich folgendes zu **path_to_project/module_name/build.gradle** hinzugefügt:
```
lintOptions {
	abortOnError false
}
```
Hierdurch wird Travis nicht mehr unterbrochen, falls ein Lint-Fehler auftritt.



## Quellen
Framework, Verfügbar unter: [https://techterms.com/definition/framework](https://techterms.com/definition/framework) [abgerufen am 11.10.2018]

Test apps on Android, Verfügbar unter: [https://developer.android.com/training/testing/](https://developer.android.com/training/testing/) [abgerufen am 18.10.2018]


Test from the command line, Verfügbar unter: [https://developer.android.com/studio/test/command-line](https://developer.android.com/studio/test/command-line) [abgerufen am 10.01.2019]
