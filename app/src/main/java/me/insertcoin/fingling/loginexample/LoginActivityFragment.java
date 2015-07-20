package me.insertcoin.fingling.loginexample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import me.insertcoin.fingling.loginexample.models.JsonWebToken;
import me.insertcoin.fingling.loginexample.models.User;
import me.insertcoin.fingling.loginexample.services.LoginService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {

    private static final String TAG = LoginActivityFragment.class.getCanonicalName();

    private CompositeSubscription subscription;

    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        subscription = new CompositeSubscription();

        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        Button signInButton = (Button) rootView.findViewById(R.id.sign_in_button);

        signInButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                AutoCompleteTextView usernameTextView = (AutoCompleteTextView)rootView.findViewById(R.id.username);
                String username = usernameTextView.getText().toString();

                TextView passwordTextView = (TextView)rootView.findViewById(R.id.password);
                String password = passwordTextView.getText().toString();

                final LoginService loginService = new LoginService(getActivity());
                subscription.add(loginService.signIn(username, password)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<JsonWebToken>() {
                            @Override
                            public void onCompleted() {
                                Log.d(TAG, "completed");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, e.getMessage(), e);
                            }

                            @Override
                            public void onNext(JsonWebToken jsonWebToken) {
                                JsonWebToken.getInstance().setToken(jsonWebToken.getToken());
                                Log.d(TAG, jsonWebToken.getToken());
                            }
                        }));
//                final LoginService loginService = new LoginService(getActivity());
//                subscription.add(loginService.singUp("test", "test", "test@insercoin.me")
//                                .subscribeOn(Schedulers.newThread())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .subscribe(new Observer<User>() {
//                                    @Override
//                                    public void onCompleted() {
//                                        Log.d(TAG, "completed");
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//                                        Log.e(TAG, e.getMessage(), e);
//                                    }
//
//                                    @Override
//                                    public void onNext(User user) {
//                                        Log.d(TAG, user.toJson());
//                                    }
//                                })
//                );
            }
        });

//        return inflater.inflate(R.layout.fragment_login, container, false);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        subscription.unsubscribe();
        super.onDestroyView();
    }
}
