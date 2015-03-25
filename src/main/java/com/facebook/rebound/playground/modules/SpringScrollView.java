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

package com.facebook.rebound.playground.modules;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.rebound.playground.R;
import com.facebook.rebound.playground.modules.scrollview.RowView1;

public class SpringScrollView extends FrameLayout {


    public SpringScrollView(Context context) {
    super(context);

    LayoutInflater inflater = LayoutInflater.from(context);
    ViewGroup root = (ViewGroup) inflater.inflate(R.layout.spring_scroll_view_example, this, false);
    ViewGroup content = (ViewGroup) root.findViewById(R.id.content_view);
    addView(root);
    setBackgroundColor(Color.argb(255, 50, 50, 50));

    int startColor = Color.argb(255, 255, 64, 230);
    int endColor = Color.argb(255, 0, 174, 255);
    ArgbEvaluator evaluator = new ArgbEvaluator();

      RowView1 rowView = new RowView1(context);
      rowView.setText(" IRE TRANSACTIONS-AUDIO\n" +
              "\n" +
              "WHY ENGINEERS SHOULD WRITE TECHNICAL PAPERS ?\n" +
              "\n" +
              "At a recent meeting of the national Administrative Committee of the IRE Professional Group on Circuit Theory we were trying to think of people to nominate for membership on this Committee. One of the members of the Professional Group had taken the trouble to write to the Editor and tell him what was wrong with one issue of the TRANSACTIOSS. I n accord with the usual attitude of such organizations, that anyone who has a good idea is chairman of the committee, he is now being considered for a nomination. This bit of writing brought him to the attention of officers looking for help, and he may soon achieve national recognition.\n" +
              "\n" +
              "Record Your Accomplishments\n" +
              "\n" +
              "Technical reports and papers are about the only sure way the younger engineers in a large company have of bringing their work to the attention of top engineering management. It may take many years of work in the laboratory before one is in charge of a n experimental project big enough to attract equal attention. When the company is looking for someone to promote to a position of great responsibility they are sure to think of those people who have regularly demonstrated, with a continuous stream of reports, technical papers, and well-writ-ten letters that they are able to think clearly and write clearly. If someone has shown that he can reduce complex problems to a simple explanation, he will inspire confidence in his ability. I t is necessary to present a record of accomplishment that is seen regularly before someone opens the door that starts you up the road to your goal.\n" +
              "\n" +
              "Technical Papers Help You and Society\n" +
              "\n" +
              "In many companies most engineers can build the kind of a future they want. It should never be necessary to keep a man on a job he doesn't like, over a long period of time. If you would like to become an internationally-known engineer or scientist you are limited only by your own ability. However, many engineers feel that personal publicity is not necessary all that the world will soon discover their real ability. Some times it does not work out this way. The man who writes UP the scientific knowledge is the one who often gets credit for having created it, even though he may have done no more than  edit: the copy. This may seem to be unfair, but actually it is not. By making the knowledge available to the public in a published paper he may have provided a far greater service to society than the engineer who created the knowledge but did not write it up for others. Be sure you get the proper credit for your work by finishing the job.\n" +
              "\n" +
              "Neglect Leads to Waste\n" +
              "\n" +
              "I have known some very good engineers who have done much valuable research and development work but who never write reports about their discoveries. In a short time the company has a big pile of obsolete equipment, with circuits partly unknown, and all of the information in the mind of one man. This is a very dangerous situation. If the man dies, retires, leaves the company, or is transferred to other work, the great investment in the experiment is lost.\n" +
              "\n" +
              "You Acquire Broader Perspective\n" +
              "\n" +
              "It is often said that the best way to learn is to teach. The first time a new course is given the teacher will learn far more than the students. When an engineer writes a technical paper which describes his work he may find loose ends that need further study. If the paper is to appear in a leading journal, and stand the test of time, it is important that i t be written as clearly as possible. The review and careful study that leads to the finished paper always gives the author a much better understanding and perspective.\n" +
              "\n" +
              "Talk to Associates\n" +
              "\n" +
              "The amount of knowledge written is only a very small part of that available. To get a t the unwritten part it is necessary to sit down with other workers in the same field and talk things over. Often it is possible to learn more in an hour this way than you could work out for yourself in weeks. The life of ex perts in science is often a lonely one, and you will be welcomed when you ask to talk to them, if you have shown by your writ ing that you are thoroughly competent and will not waste their time.\n" +
              "\n" +
              "Help Is Available\n" +
              "\n" +
              "The PGA officers want to improve the number and quality of the technical papers written. They will do everything possible to help you. The first paper is the hard one to write. How long should it be? Who will make the drawings? What is the approved form for typing the manuscript? Once you have done one paper, these questions are easy.The responsibility for your development and advancement is entirely yours. Why not start now?\n" +
              "\n" +
              "-VI. S. CORRINGTON,\n" +
              "Vice-Chairman\n " );

      content.addView(rowView);
    }
  }


