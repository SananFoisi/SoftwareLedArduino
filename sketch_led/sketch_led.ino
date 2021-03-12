int statusLed = 0; //LIGADO OU DESLIGADO
const int LED = 12; //PINO LED


void setup() {

  Serial.begin(9600); //taxa de tranferencia
  pinMode(LED, OUTPUT); //pino de saida
  digitalWrite(LED, LOW); //iniciar em desligado

}

void loop() {
 
  if (Serial.available() > 0) { //verifica se foi enviado algo pela porta

    statusLed = Serial.read(); //ler o que foi enviado pela porta serial
    if (statusLed == '0') {
      digitalWrite(LED, LOW);
    } else if (statusLed == '1') {
      digitalWrite(LED, HIGH);
    }
  }

}
