package com.kendaraan.sewa.aplikasi.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kendaraan.sewa.aplikasi.Domain.Pelanggan;
import com.kendaraan.sewa.aplikasi.R;
import com.kendaraan.sewa.aplikasi.dto.RestBaseRespone;
import com.kendaraan.sewa.aplikasi.service.HttpService;

import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PelangganFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PelangganFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PelangganFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View rootView;
    private HttpService httpService = new HttpService();

    private OnFragmentInteractionListener mListener;

    public PelangganFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PelangganFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PelangganFragment newInstance(String param1, String param2) {
        PelangganFragment fragment = new PelangganFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_pelanggan, container, false);

        new GetPelangganExecutor().execute();

        ListView lvPelanggan = rootView.findViewById(R.id.lv_pelanggan);

        String[] arrPelanggan = {"Abdul","Rahman","Agung"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrPelanggan);
        lvPelanggan.setAdapter(adapter);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class GetPelangganExecutor extends AsyncTask<Void, Void, Object>{

        @Override
        protected Object doInBackground(Void... voids){
            try {
                ResponseEntity<RestBaseRespone> respPelanggan = httpService.getAllPelanggan2();
                return respPelanggan;
            }catch (Exception e){
                return e.getLocalizedMessage();
            }
        }

        @Override
        protected void onPostExecute(Object resp) {
            super.onPostExecute(resp);
            if (resp instanceof ResponseEntity){
                ResponseEntity<RestBaseRespone> respPelanggan = (ResponseEntity) resp;
                RestBaseRespone pelangganResp = respPelanggan.getBody();

                if (pelangganResp.getStatus().equals("sukses")){
                    List<Pelanggan> pelanggans = (List<Pelanggan>) pelangganResp.getData();
                    Toast.makeText(getActivity(), pelanggans.toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(), pelangganResp.getMessege(), Toast.LENGTH_LONG).show();
                }
            }else {
                String errorMsg = (String) resp;
                Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
