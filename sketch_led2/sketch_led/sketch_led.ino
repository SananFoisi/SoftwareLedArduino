int statusLED_1 = 0; //LIGADO OU DESLIGADO
int statusLED_2 = 0;

const int LED_1 = 11; //PINO LED_1
const int LED_2 = 12;

void setup() {

  Serial.begin(9600); //taxa de tranferencia
  pinMode(LED_1, OUTPUT); //pino de saida
  digitalWrite(LED_1, LOW); //iniciar em desligado

  pinMode(LED_2, OUTPUT); //pino de saida
  digitalWrite(LED_2, LOW); //iniciar em desligado

}

void loop() {

  if (Serial.available() > 0) { //verifica se foi enviado algo pela porta

    statusLED_1 = Serial.read(); //ler o que foi enviado pela porta serial
    if (statusLED_1 == '0') {
      digitalWrite(LED_1, LOW);
    } else if (statusLED_1 == '1') {
      digitalWrite(LED_1, HIGH);
    }

   statusLED_2 = Serial.read(); //ler o que foi enviado pela porta serial
    if (statusLED_2 == '0') {
      digitalWrite(LED_2, LOW);
    } else if (statusLED_2 == '1') {
      digitalWrite(LED_2, HIGH);
    }

    
  }

}
