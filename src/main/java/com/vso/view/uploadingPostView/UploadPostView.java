package com.vso.view.uploadingPostView;

import com.vso.model.entity.Post;

import java.util.Scanner;

public class UploadPostView {

    private Scanner scanner;

    public UploadPostView() {
        this.scanner = new Scanner(System.in);
    }

    public void getText(String text){
        System.out.println(text);
    }

    public String getTextInput() {
        return scanner.nextLine();
    }


    public void printPost(Post post) {
        System.out.println("Author:" + post.getUser().getName());
        System.out.println("Description:" + post.getText());
        System.out.println();
        System.out.println("Date:" + post.getDate());
    }

    public int getNumber() {
        int number = scanner.nextInt();
        return number;
    }
}
