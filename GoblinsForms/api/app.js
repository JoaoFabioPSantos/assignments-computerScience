const express = require('express');
const cors = require('cors'); 
const app = express();

app.use(cors()); 
app.use(express.json());

app.get('/', (req, res) => {
  res.send('Goblins Forms API - Funcionando 🟢');
});

const gnomesRoutes = require('./src/routes/gnomes');

app.use('/api', gnomesRoutes);

app.use((req, res) => {
  res.status(404).json({ erro: 'Rota não encontrada' });
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`--- Goblins Forms ---`);
  console.log(`Servidor rodando na porta ${PORT}`);
});