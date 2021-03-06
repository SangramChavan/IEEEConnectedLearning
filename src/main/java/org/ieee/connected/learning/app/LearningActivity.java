/*
 * This file provided by Facebook is for non-commercial testing and evaluation purposes only.
 * Facebook reserves all rights not expressly granted.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * FACEBOOK BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.ieee.connected.learning.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.ieee.connected.SpringUtil;
import org.ieee.connected.learning.R;
import org.ieee.connected.learning.modules.About;
import org.ieee.connected.learning.modules.Collabratec;
import org.ieee.connected.learning.modules.Computer;
import org.ieee.connected.learning.modules.DigitalToolbox;
import org.ieee.connected.learning.modules.Publish;
import org.ieee.connected.learning.modules.Safari;
import org.ieee.connected.learning.modules.Spectrum;
import org.ieee.connected.learning.modules.SpringScrollView;
import org.ieee.connected.learning.modules.Springchain;
import org.ieee.connected.learning.modules.Xplore;
import org.ieee.connected.learning.modules.myIEEE;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class LearningActivity extends Activity implements AdapterView.OnItemClickListener {

  private static final List<Sample> SAMPLES = new ArrayList<Sample>();

  static {
    SAMPLES.add(new Sample(Springchain.class, "About", " IEEE Mission & Vision"));
    SAMPLES.add(new Sample(Collabratec.class, "IEEE Collabratec™", "IEEE Collabratec™|Bright Minds. Bright Ideas.\n a research, collaboration & professional networking"));
    SAMPLES.add(new Sample(SpringScrollView.class, "Why Engineers Should Write Technical Papers ?", "IRE TRANSACTIONS  -M.S. CORRINGTON,Vice-Chairma"));
    SAMPLES.add(new Sample(Xplore.class, "IEEE Xplore® Digital Library", "The IEEE Xplore® digital library provides access to IEEE journals, transactions, letters, magazines more.."));
    SAMPLES.add(new Sample(myIEEE.class, "myIEEE ", "myIEEE is for IEEE Members customizable page containing \"gadgets\"."));
    SAMPLES.add(new Sample(Publish.class, "IEEE Publications ", "Browse IEEE publications and standards and visit the IEEE Xplore Digital Library."));
    SAMPLES.add(new Sample(DigitalToolbox.class, "IEEE Digital Tool box", "Contains tools and information to assist with article preparation and submission, the article proof review,etc."));
    SAMPLES.add(new Sample(Computer.class, "Publish with Computer Society", "Information about CS Transactions authors, editors, reviewers, editors in chief, and guest editors."));
    SAMPLES.add(new Sample(Spectrum.class, "Spectrum", "Latest engineering, technology and science news. Articles, podcasts, videos, and webinars."));
    SAMPLES.add(new Sample(Safari.class, "Safari", "IEEE Computer Society users use direct access account to access Safari Books Online library."));
    SAMPLES.add(new Sample(About.class, "Contact us", "The mind of the scholar, if he would leave it large and liberal, should come in contact with other minds. -Henry"));
  }

  private ListView mListView;
  private View mRootContainer;
  private ExampleListAdapter mAdapter;
  private ViewGroup mRootView;
  private ContainerView mCurrentExample;
  private boolean mAnimating;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_playground);
    mRootView = (ViewGroup) findViewById(R.id.root);
    mRootContainer = findViewById(R.id.root_container);
    mListView = (ListView) findViewById(R.id.list_view);
    mAdapter = new ExampleListAdapter();
    mListView.setAdapter(mAdapter);

    mListView.setOnItemClickListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.playground, menu);

      return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
     int id = item.getItemId();
      switch(item.getItemId())
      {
          case R.id.Home:
              Intent i=new Intent(this, LearningActivity.class);
              i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(i);
              break;
          case R.id.Exit:
              System.exit(0);
              break;
          case R.id.About:
              String url = "http://goo.gl/forms/6GHr6YVtwP";
              Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
              startActivity(browserIntent);
              break;
          case R.id.Download:
              String url1 = "https://m.ieee.org/publications_standards/publications/authors/author_templates.html";
              Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
              startActivity(browserIntent1);
              break;
          case R.id.tv:
              String url2 = "https://ieeetv.ieee.org/";
              Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
              startActivity(browserIntent2);
              break;

      }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    if (mAnimating) {
      return;
    }

    Class<? extends View> clazz = SAMPLES.get(position).viewClass;
    View sampleView = null;
    try {
      Constructor<? extends View> ctor = clazz.getConstructor(Context.class);
      sampleView = ctor.newInstance(LearningActivity.this);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    if (sampleView == null) {
      return;
    }
    mAnimating = true;

    mCurrentExample = new ContainerView(this);
    mCurrentExample.addView(sampleView);
    mRootView.addView(mCurrentExample);

    mCurrentExample.postDelayed(new Runnable() {
        @Override
        public void run() {
            mCurrentExample.reveal(true, new ContainerView.Callback() {
                @Override
                public void onProgress(double progress) {
                    float scale = (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, 0.8, 1);
                    mRootContainer.setScaleX(scale);
                    mRootContainer.setScaleY(scale);
                    mRootContainer.setAlpha((float) progress);
                }

                @Override
                public void onEnd() {
                    mAnimating = false;
                }
            });
        }
    }, 100);
  }

  @Override
  public void onBackPressed() {
        if (mAnimating || mCurrentExample == null) {
      return;
    }
    mAnimating = true;
      mCurrentExample.hide(true, new ContainerView.Callback() {
      @Override
      public void onProgress(double progress) {
        float scale = (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, 0.8, 1);
        mRootContainer.setScaleX(scale);
        mRootContainer.setScaleY(scale);
        mRootContainer.setAlpha((float) progress);
      }
        @Override
      public void onEnd() {
        mAnimating = false;
        mCurrentExample.clearCallback();
        mRootView.removeView(mCurrentExample);
        mCurrentExample = null;
      }
    });
  }

  private class ExampleListAdapter implements ListAdapter {

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {}

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public int getCount() {
      return SAMPLES.size();
    }

    @Override
    public Object getItem(int position) {
      return SAMPLES.get(position);
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    @Override
    public boolean hasStableIds() {
      return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      RowView rowView;
      if (convertView != null) {
        rowView = (RowView) convertView;
      } else {
        rowView = new RowView(LearningActivity.this);
      }
      rowView.setText(SAMPLES.get(position).text);
      rowView.setSubtext(SAMPLES.get(position).subtext);
      return rowView;
    }

    @Override
    public int getItemViewType(int position) {
      return 0;
    }

    @Override
    public int getViewTypeCount() {
      return 1;
    }

    @Override
    public boolean isEmpty() {
      return SAMPLES.isEmpty();
    }

    @Override
    public boolean areAllItemsEnabled() {
      return true;
    }

    @Override
    public boolean isEnabled(int position) {
      return true;
    }
  }

  private static class Sample {
    public Class<? extends View> viewClass;
    public String text;
    public String subtext;

    public Sample(Class<? extends View> viewClass, String text, String subtext) {
      this.viewClass = viewClass;
      this.text = text;
      this.subtext = subtext;
    }
  }
}