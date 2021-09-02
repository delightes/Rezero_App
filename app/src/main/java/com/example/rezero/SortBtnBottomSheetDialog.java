package com.example.rezero;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class SortBtnBottomSheetDialog extends BottomSheetDialogFragment {

    static Context context;//즐겨찾기위해
    // 초기변수 설정
    private View view;
    // 인터페이스 변수
    private BottomSheetListener mListener;
    // 바텀시트 숨기기 버튼
    private Button btn_hide_bt_sheet,okCategory;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //ProductFragment.java에서 눌린 버튼아이디 받기
        //그아이디가 인기순버튼일경우 sort_btnbottom_sheet를 view로 인플레이트하기
        //그아이디가 카테고리일경우 view를 카테고리 바텀시트로 인플레이트하기

        if(ProductFragment.selectedBtnId== R.id.sortBtn){
            view = inflater.inflate(R.layout.sort_btn_bottom_sheet, container, false);
            btn_hide_bt_sheet = view.findViewById(R.id.btn_hide_bt_sheet);
            btn_hide_bt_sheet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return view;
        }else if (ProductFragment.selectedBtnId== R.id.categoryBtn){
            view = inflater.inflate(R.layout.category_btn_bottom_sheet, container, false);
            okCategory = view.findViewById(R.id.okCategory);
            okCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            return view;
        }




        return inflater.inflate(R.layout.fragment_product, container, false);//프로덕트프래그먼트에서 제대로 정보못받앗을때
    }
    // 부모 액티비티와 연결하기위한 인터페이스
    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

}
