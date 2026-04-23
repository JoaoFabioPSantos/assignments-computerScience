const express = require('express');
const axios = require('axios');
const app = express();

// A porta da sua API de Gnomos
const API_BASE_URL = 'http://localhost:3000/api'; 

app.use(express.static('public'));
app.use(express.json());

// Proxy para Listar Gnomos
app.get('/api/gnomes', async (req, res) => {
  try {
    const response = await axios.get(`${API_BASE_URL}/gnomes`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao buscar gnomos' });
  }
});

// Proxy para Criar Gnomo
app.post('/api/gnomes', async (req, res) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/gnomes`, req.body);
    res.status(201).json(response.data);
  } catch (error) {
    res.status(400).json({ error: 'Erro ao convocar gnomo' });
  }
});

// Proxy para Listar Fórmulas (Com os nomes dos Gnomos)
app.get('/api/formulas', async (req, res) => {
  try {
    const response = await axios.get(`${API_BASE_URL}/formulas`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao buscar fórmulas' });
  }
});

// Proxy para Buscar Fórmulas de um Gnomo específico
app.get('/api/formulas/gnomo/:id', async (req, res) => {
  try {
    const response = await axios.get(`${API_BASE_URL}/formulas/gnomo/${req.params.id}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao buscar fórmulas por gnomo' });
  }
});

// Proxy para Criar Fórmula
app.post('/api/formulas', async (req, res) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/formulas`, req.body);
    res.status(201).json(response.data);
  } catch (error) {
    res.status(400).json({ error: 'Erro ao gravar fórmula' });
  }
});

// Proxy para Deletar Fórmula
app.delete('/api/formulas/:id', async (req, res) => {
  try {
    const response = await axios.delete(`${API_BASE_URL}/formulas/${req.params.id}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Erro ao apagar fórmula' });
  }
});

app.listen(3001, () => {
  console.log('--- Gnomes Forms Web Server ---');
  console.log('Acesse: http://localhost:3001');
});