//package com.boutique.controller;
//
//import com.boutique.entity.Produit;
//import com.boutique.repository.ProduitRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.springframework.security.test.context.support.WithMockUser;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ProduitControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ProduitRepository produitRepository;
//
//    @BeforeEach
//    void setUp() {
//        produitRepository.deleteAll();
//    }
//
//    @Test
//    @WithMockUser(username = "client1", roles = {"CLIENT"})
//    void testCreateAndGetProduit() throws Exception {
//        String produitJson = "{\"nom\":\"Test\",\"description\":\"Desc\",\"prixUnitaire\":10.5}";
//        // Création
//        mockMvc.perform(post("/api/produits")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(produitJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").exists());
//        // Lecture
//        mockMvc.perform(get("/api/produits"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Test"));
//    }
//
//    @Test
//    @WithMockUser(username = "manager", roles = {"MANAGER"})
//    void testUpdateProduit() throws Exception {
//        Produit produit = new Produit();
//        produit.setNom("Ancien");
//        produit.setDescription("Desc");
//        produit.setPrixUnitaire(5.0);
//        produit = produitRepository.save(produit);
//        String updateJson = "{\"nom\":\"Nouveau\",\"description\":\"Desc\",\"prixUnitaire\":15.0}";
//        mockMvc.perform(put("/api/produits/" + produit.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(updateJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nom").value("Nouveau"));
//    }
//
//    @Test
//    @WithMockUser(username = "manager", roles = {"MANAGER"})
//    void testDeleteProduit() throws Exception {
//        Produit produit = new Produit();
//        produit.setNom("A supprimer");
//        produit.setDescription("Desc");
//        produit.setPrixUnitaire(7.0);
//        produit = produitRepository.save(produit);
//        mockMvc.perform(delete("/api/produits/" + produit.getId()))
//                .andExpect(status().isOk());
//        mockMvc.perform(get("/api/produits/" + produit.getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().string(""));
//    }
//}
