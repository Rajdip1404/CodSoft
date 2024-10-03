import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.HashMap;

public class currency_Converter {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> currencyCodes = new HashMap<>();
        currencyCodes.put(1, "AUD (Australian Dollar)");
        currencyCodes.put(2, "USD (US Dollar)");
        currencyCodes.put(3, "EUR (Euro)");
        currencyCodes.put(4, "INR (Indian Rupees)");
        currencyCodes.put(5, "CNY (Chinese Yuan)");
        currencyCodes.put(6, "JPY (Japanese Yen)");
        currencyCodes.put(7, "NZD (Newzeland Dollar)");
        currencyCodes.put(8, "RUB (Russian Ruble)");
        currencyCodes.put(9, "EGP (Egyptian Pound)");
        currencyCodes.put(10, "SGD (Singapore Dollar)");

        String fromCode, toCode;
        double ammount;

        for(int i=0; i<currencyCodes.size(); i++){
            System.out.println("Enter " + (i+1) + " for " + currencyCodes.get(i+1));
        }

        System.out.print("Converting currency from: ");
        fromCode = currencyCodes.get(sc.nextInt()).substring(0,3);
        System.out.print("Converting currency to: ");
        toCode = currencyCodes.get(sc.nextInt()).substring(0,3);
        System.out.print("Enter the amount: ");
        ammount = sc.nextDouble();

        sendHttpGETRequest(fromCode, toCode, ammount);
    }

    private static final String API_KEY = "fca_live_emfBJYY0vuVozfffE0mCLGBE5ac7sSI9TN6AOSMP";
    private static final String API_URL = "https://api.freecurrencyapi.com/v1/latest?apikey=" + API_KEY;
    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {
        String GET_URL = API_URL + "&currencies=" + toCode + "&base_currency=" + fromCode;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        StringBuffer response = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = bf.readLine()) != null) {
                response.append(inputLine);
            }bf.close();

        JSONObject obj = new JSONObject(response.toString());
        Double rate = obj.getJSONObject("data").getDouble(toCode) * amount;

        System.out.println(amount + " " + fromCode + " = " + rate.floatValue() + " " + toCode);
        }
        else{
            throw new HttpRetryException("Unexpected response code: " + responseCode, responseCode);
        }
    }
}
