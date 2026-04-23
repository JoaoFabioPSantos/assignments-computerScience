const express = require('express');
const router = express.Router();
const gnomesController = require('../controllers/gnomesController');

// Rotas de Gnomos
router.get('/gnomes', gnomesController.listar);
router.post('/gnomes', gnomesController.criar);

// Rotas de Fórmulas
router.get('/formulas', gnomesController.listarTodasComGnomos);
router.get('/formulas/gnomo/:id', gnomesController.listarPorGnomo);
router.post('/formulas', gnomesController.salvarFormula);
router.delete('/formulas/:id', gnomesController.deletarFormula);

module.exports = router;