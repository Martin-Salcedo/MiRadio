package com.example.martinsalcedo.miradio.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.martinsalcedo.miradio.R;
import com.example.martinsalcedo.miradio.domain.Artist;
import com.example.martinsalcedo.miradio.io.RadioApiAdapter;
import com.example.martinsalcedo.miradio.io.model.ArtistResponse;
import com.example.martinsalcedo.miradio.ui.adapter.HipedArtistsAdater;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by martinsalcedo on 07/08/16.
 */

public class HipedArtistFragment extends Fragment implements Callback<ArtistResponse> {

    public static final String TAG =  HipedArtistFragment.class.getSimpleName();

    public static final int NUM_COLUMNAS = 2;

    private RecyclerView mHipedArtistList;

    private HipedArtistsAdater adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HipedArtistsAdater(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hiped_artist, container, false);

        mHipedArtistList = (RecyclerView) root.findViewById(R.id.hiped_artist_list);

        setupArtistList();
//        setDummyContent();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        RadioApiAdapter.getApiService().getArtists(this);
    }

    public void setupArtistList(){
        // El GridLayoutManager recibe como parametros el contexto y el numero de columnas
        mHipedArtistList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMNAS));
        mHipedArtistList.setAdapter(adapter);
        mHipedArtistList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));

    }

    private void setDummyContent(){
        ArrayList<Artist> artists = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            artists.add(new Artist("Artist: " +i));
        }

        adapter.addAll(artists);
    }

    @Override
    public void success(ArtistResponse artistResponse, Response response) {
        Log.d(TAG, String.valueOf(artistResponse.getArtist()));
        adapter.addAll(artistResponse.getArtist());
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
