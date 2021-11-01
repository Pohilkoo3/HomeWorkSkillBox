

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        //TODO: напишите метод генерации массива температур пациентов
        float[] temperature = new float[patientsCount];
        for (int i = 0; i < temperature.length; i++){
            temperature[i] = (float) Math.random()*((39-32)+1)+32;
        }
        return temperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        float summaTemperature = 0;
        int countHealth = 0;
        StringBuilder temperatureOutput = new StringBuilder();
        for (int i = 0; i < temperatureData.length; i++){
            summaTemperature += temperatureData[i];
            temperatureOutput.append(temperatureData[i]).append(' ');
            if (temperatureData[i] >= 36.2 && temperatureData[i] <= 36.99){
                countHealth++;
            }
        }
        float averageTemperature = (float) (Math.round ((summaTemperature/temperatureData.length)*100))/100;

        String report =
                "Температуры пациентов: " + (temperatureOutput.toString()).trim() +
                        "\nСредняя температура: " + averageTemperature +
                        "\nКоличество здоровых: " + countHealth;
        return report;
    }
}
