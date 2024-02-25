package com.example.travelapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class home extends Fragment {

    RecyclerView recyclerView;
    ArrayList<destinationModel> dataset = new ArrayList<>();
    String json = null;

    public home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Access AssetManager and load JSON data
        AssetManager assetManager = requireContext().getAssets();
        try {
            InputStream is = assetManager.open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Parse JSON data and populate dataset


                try {
                    JSONObject jsonObject = new JSONObject(json);

                    JSONArray statesArray = jsonObject.getJSONArray("state");


                    for (int i = 0; i < statesArray.length(); i++) {
                        destinationModel model = new destinationModel();

                        JSONObject stateObject = statesArray.getJSONObject(i);


                        if (stateObject.has("id")) {
                            model.id = stateObject.getString("id");
                        }

                        if (stateObject.has("name")) {
                            model.name = stateObject.getString("name");
                        }


                        if (stateObject.has("capital")) {
                            model.capital = stateObject.getString("capital");
                        }


                        if (stateObject.has("about")) {
                            model.about = stateObject.getString("about");
                        }


                        if (stateObject.has("climate")) {
                            model.climate = stateObject.getString("climate");
                        }


                        if (stateObject.has("history")) {
                            model.history = stateObject.getString("history");
                        }


                        if (stateObject.has("food")) {
                            model.food = stateObject.getString("food");
                        }


                        if (stateObject.has("img")) {
                            JSONArray images = stateObject.getJSONArray("img");
                            for (int j = 0; j < images.length(); j++) {
                                String imgurl = images.getString(j);
                                model.img.add(imgurl);

                            }
                        }


                        if (stateObject.has("products")) {
                            JSONArray products = stateObject.getJSONArray("products");
                            for (int j = 0; j < products.length(); j++) {
                                JSONObject productObject = products.getJSONObject(j);
                                productsModel product = new productsModel();

                                if (productObject.has("name")) {
                                    product.name = productObject.getString("name");
                                }

                                if (productObject.has("description")) {
                                    product.description = productObject.getString("description");
                                }

                                if (productObject.has("image")) {
                                    product.image = productObject.getString("image");
                                }

                                if (productObject.has("category")) {
                                    product.category = productObject.getString("category");
                                }
                                model.products.add(product);
                            }
                        }


                        dataset.add(model);
                    }


                    // Set adapter for RecyclerView
                    customAdapter adapter = new customAdapter(getContext(), dataset);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException ex) {
                    throw new RuntimeException(ex);
                }

                return view;
            }
        }

