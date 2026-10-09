# Will You Be My Valentine? 💝

A single-screen Android app that asks one question. The **NO** button shrinks
and runs out of excuses; the **YES** button grows. Saying yes sets off floating
hearts and a sunflower.

Built to be editable by someone who doesn't write code.

---

## The only file you need to edit

**`index.html`** — in the top folder of this repository.

Open it, scroll to the block that says
`EVERYTHING YOU'D WANT TO CHANGE IS IN THIS ONE BLOCK`, and change the text
between the quotation marks. That's the name, the question, every button
label, and the celebration message.

Rules: keep the quotation marks, keep the commas at the end of each line.

**To see your changes:** double-click `index.html` on your computer. It opens
in your web browser and behaves exactly like the app will. No tools, no
installing anything, no waiting. Make a change, save, refresh the browser.

Colours live just above that, in the block marked `COLOURS & FONTS` — change
the `#RRGGBB` codes.

---

## Getting the APK

You never install Android Studio and you never run a compiler. GitHub does it.

1. Edit `index.html` and save it to this repository (commit).
2. Go to the **Actions** tab at the top of this repository on github.com.
3. The newest run appears at the top. Wait for the green tick (~2–3 minutes).
4. Click that run. Scroll to the bottom, to **Artifacts**.
5. Download **`will-you-be-my-valentine-apk`**. It arrives as a `.zip`;
   unzip it to get `will-you-be-my-valentine.apk`.

If you'd rather not edit anything, just open the Actions tab, click
**Build APK** on the left, then **Run workflow** — it builds from what's
already here.

### Installing it on an Android phone

Send the `.apk` file to the phone (email, WhatsApp, Google Drive, USB cable).
Tap it, then work through the warnings Android shows for any app that didn't
come from the Play Store:

- *"For your security, your phone is not allowed to install unknown apps
  from this source"* → **Settings** → turn the switch on for whichever app
  you're installing from → go back and tap the file again.
- *"Install anyway?"* from Play Protect → **Install anyway**.

This app declares **no permissions at all** — no internet, no storage, no
contacts — so the install screen has nothing alarming to list. Worth saying
out loud to whoever you send it to.

---

## What's in here

| Path | What it is |
|---|---|
| `index.html` | The entire app — layout, text, animations. **Edit this.** |
| `android/` | The thin Android shell that displays it. You shouldn't need to touch it. |
| `android/app/src/main/java/.../MainActivity.java` | ~45 lines: open a full-screen WebView, load the page. |
| `.github/workflows/build-apk.yml` | The instructions GitHub follows to compile the APK. |
| `main.py`, `sunflower.py` | The original Python/Tkinter desktop version. **Does not run on Android** — kept for reference only. |

## How it's put together

The app is a native Android app whose only screen is a WebView showing
`index.html`, bundled inside the APK. Nothing is fetched from the internet,
so it works in airplane mode and can't fail at the moment it matters.

Gradle copies the root `index.html` into the app's assets on every build,
so there's exactly one copy of the page to keep track of.

**Trade-off, stated plainly:** a WebView-only app would be rejected from the
Google Play Store as a "repackaged website". That's fine here — this is a
sideloaded gift, not a listing. If you ever want it on the Play Store, the UI
has to be rebuilt natively.

## Credit

The grow-the-YES-button idea and the sunflower drawing come from
[Sandreke/valentines-proposal](https://github.com/Sandreke/valentines-proposal)
and [Sandreke/turtle-python](https://github.com/Sandreke/turtle-python).
